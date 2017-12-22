package com.edu.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class AppComponent {

	@Value("${local.port}")
	private Integer localPort;
	
	@Autowired
	private Environment environment;
	public void show() {
		System.out.println("local.port: "+ localPort);
		System.out.println("local.url: " + environment.getProperty("local.url"));
		System.out.println("local.url2: " + environment.getProperty("local.url2"));
		
	}
}
