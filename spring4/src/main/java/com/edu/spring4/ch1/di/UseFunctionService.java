package com.edu.spring4.ch1.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UseFunctionService {

	/**
	 * @Autowired 将实体Bean 注入到 UseFunctionService 中，
	 * 此注解和@Inject、@Resource 是等效的。
	 * 
	 */
	@Autowired
	FunctionService functionService;
	
	String sayHello(String word){
		return functionService.sayHello(word);
	}
}
