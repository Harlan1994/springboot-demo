package com.seclab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 首先要将spring boot自带的DataSourceAutoConfiguration禁掉，
 * 因为它会读取application.properties文件的spring.datasource.*属性并自动配置单数据源。
 * 在@SpringBootApplication注解中添加exclude属性即可：
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableTransactionManagement(order = 2) // 设置事务执行顺序(需要在切换数据源之后，否则只走默认库)
//@EnableAutoConfiguration
@EnableWebMvc
public class SpringbootDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}
}
