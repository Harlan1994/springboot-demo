package com.seclab.aspect;

import com.seclab.annotation.DataSource;
import com.seclab.domain.datasource.CustomContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/4/4
 * Time: 09:47
 * Description:
 */
@Aspect
@Component
@Order(1)
public class DataSourceAspect {

    // 拦截有@DataSource注解的方法
    @Pointcut("@annotation(com.seclab.annotation.DataSource)")
    public void pointCut() {
    }

    String dataSource = CustomContextHolder.DATA_SOURCE_MASTER;

    @Before(value = "pointCut()")
    public void before(JoinPoint point) {

        Class<?> clazz = point.getTarget().getClass();
        String methodName = point.getSignature().getName();
        Class[] classes = ((MethodSignature) point.getSignature()).getParameterTypes();

        try {
            Method method = clazz.getMethod(methodName, classes);
            if (method != null && method.isAnnotationPresent(DataSource.class)) {
                DataSource data = method.getAnnotation(DataSource.class);
                dataSource = data.value();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        CustomContextHolder.setDataSource(dataSource);
    }

    @After(value = "pointCut()")
    public void after() {
        CustomContextHolder.clearDataSource();
    }
}
