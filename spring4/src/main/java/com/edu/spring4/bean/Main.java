package com.edu.spring4.bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
		context.getBeansOfType(User.class).values().forEach(System.out :: println);
		context.close();
	}
}
