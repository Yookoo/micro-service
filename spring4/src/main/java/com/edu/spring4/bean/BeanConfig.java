package com.edu.spring4.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration 声明当前类为配置类
 * @ComponentScan("com.edu.spring4.bean.beanpostprocessor") 配置自动扫描包下所有组件
 * @author Administrator
 * 
 */
@Configuration
@ComponentScan("com.edu.spring4.bean")
public class BeanConfig {
	
	//@Bean(initMethod="init")
	public User user() {
		return new User();
	}

}
