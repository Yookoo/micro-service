package com.edu.spring4.ch1.aop;

import org.springframework.stereotype.Service;

@Service
public class DemoMethodService {

	void add() {
		System.out.println("执行DemoMethodService的add方法");
	}
}
