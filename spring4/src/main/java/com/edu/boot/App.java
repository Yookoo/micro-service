package com.edu.boot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {
	/**
	 * @SpringBootApplication 中 包含 @Configuration 注解，所以可以直接在此处注入bean
	 * @return
	 */
	@Bean
	public Runnable runnable() {
		return () -> {System.out.println("-----------springboot is run-----------");};
	}
		
	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
		context.getBean(Runnable.class).run();
	
		/*
		 * 获取配置文件中的值
		 * 1. context.getEnvironment().getProperty("local.ip");
		 *    注入Environment对象，getProperty("local.ip");
		 * 2. 使用 @Value("${local.port}") 注入(无法注入为静态变量)
		 */
		String property = context.getEnvironment().getProperty("local.ip");
		System.out.println("local.ip: "+ property);
		context.getBean(AppComponent.class).show();
		context.close();
	}

}
