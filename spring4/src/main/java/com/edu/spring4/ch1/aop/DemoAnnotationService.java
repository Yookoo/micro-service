package com.edu.spring4.ch1.aop;

import org.springframework.stereotype.Service;

@Service
public class DemoAnnotationService {

	@Action(name="注解式拦截的add操作")
	void add() {
		System.out.println("执行DemoAnnotationService的add方法");
	}
}
