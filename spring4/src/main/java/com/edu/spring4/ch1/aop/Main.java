package com.edu.spring4.ch1.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
		DemoAnnotationService annotationService = context.getBean(DemoAnnotationService.class);
		DemoMethodService methodService = context.getBean(DemoMethodService.class);
		annotationService.add();
		System.out.println("-------------");
		methodService.add();
		context.close();
	}
}
