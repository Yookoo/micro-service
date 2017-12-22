package com.spring.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cloud.entity.User;
import com.spring.cloud.feign.UserFeignClient;

@RestController
public class MovieFeignController {

	@Autowired
	private UserFeignClient userFeignClient;
	
	@GetMapping("/feign/movie/user/{id}")
	public User findById(@PathVariable Long id) {
		return userFeignClient.findById(id);
	}
}
