package com.spring.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.spring.cloud.entity.User;

@RestController
public class MovieController {

	private final static String user_service_url = "http://ms-provider-user/user/";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/movie/user/{id}")
	public User findUserById(@PathVariable Long id) {
		return restTemplate.getForObject(user_service_url + id, User.class);
	}
}
