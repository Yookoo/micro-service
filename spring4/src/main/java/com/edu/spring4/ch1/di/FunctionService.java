package com.edu.spring4.ch1.di;

import org.springframework.stereotype.Service;

/**
 * @Service 注解声明当前FunctionService类是Spring管理的一个Bean。
 * 其与@Component、@Repository、@Controller是等效的，可根据需要选用。
 *
 * @author Administrator
 *
 */
@Service
public class FunctionService {

	String sayHello(String word){
		return String.format("Hello %s !", word);
	}
}
