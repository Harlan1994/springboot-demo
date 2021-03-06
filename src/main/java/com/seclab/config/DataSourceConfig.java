package com.seclab.config;

import com.seclab.config.druid.AbstractDruidDBConfig;
import com.seclab.datasource.CustomContextHolder;
import com.seclab.datasource.DynamicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/4/4
 * Time: 09:57
 * Description:
 */
@Configuration
public class DataSourceConfig extends AbstractDruidDBConfig {

    @Value("${spring.datasource.master.jdbcUrl}")
    private String masterUrl;

    @Value("${spring.datasource.master.username}")
    private String masterUsername;

    @Value("${spring.datasource.master.password}")
    private String masterPassword;

    @Value("${spring.datasource.slaver.jdbcUrl}")
    private String slaverUrl;

    @Value("${spring.datasource.slaver.username}")
    private String slaverUsername;

    @Value("${spring.datasource.slaver.password}")
    private String slaverPassword;

    /**
     * @return
     * @throws Exception
     * @Primary 该注解表示在同一个接口有多个实现类可以注入的时候，默认选择哪一个，而不是让@autowire注解报错
     */
    @Bean("masterDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource masterDataSource() throws Exception {
        return super.createDataSource(masterUrl, masterUsername, masterPassword);
    }

    @Bean("slaverDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.slaver")
    public DataSource slaverDataSource() throws Exception {
        return super.createDataSource(slaverUrl, slaverUsername, slaverPassword);
    }

    /**
     * @Qualifier 根据名称进行注入，通常是在具有相同的多个类型的实例的一个注入（例如有多个DataSource类型的实例）
     */
    @Primary
    @Bean("dynamicDataSource")
    public DynamicDataSource dynamicDataSource(@Qualifier("masterDataSource") DataSource masterDataSource,
                                               @Qualifier("slaverDataSource") DataSource slaverDataSource) {
        Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
        targetDataSources.put(CustomContextHolder.DATA_SOURCE_MASTER, masterDataSource);
        targetDataSources.put(CustomContextHolder.DATA_SOURCE_SLAVER, slaverDataSource);

        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSources);// 该方法是AbstractRoutingDataSource的方法
        dataSource.setDefaultTargetDataSource(masterDataSource);// 默认的datasource设置为myTestDbDataSource

        return dataSource;
    }

    /**
     * 根据数据源创建SqlSessionFactory
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dynamicDataSource") DynamicDataSource dynamicDataSource,
                                               @Value("${mybatis.typeAliasesPackage}") String typeAliasesPackage,
                                               @Value("${mybatis.mapperLocations}") String mapperLocations) throws Exception {
        return super.sqlSessionFactory(dynamicDataSource, mapperLocations, typeAliasesPackage);
    }

    /**
     * 配置事务管理器
     */
    @Bean
    public DataSourceTransactionManager transactionManager(DynamicDataSource dataSource) throws Exception {
        return new DataSourceTransactionManager(dataSource);
    }
}
