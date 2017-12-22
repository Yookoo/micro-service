package com.spring.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.EurekaClient;
import com.spring.cloud.entity.User;

@RestController
public class MovieController {

	private final static String user_service_url = "http://ms-provider-user/user/";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@GetMapping("/movie/user/{id}")
	public User findUserById(@PathVariable Long id) {
		return restTemplate.getForObject(user_service_url + id, User.class);
	}
	@GetMapping("/movie/user/eureka")
	public String getEurekaInstance() {
		 ServiceInstance serviceInstance = this.loadBalancerClient.choose("ms-provider-user");
		 return serviceInstance.getHost()+":"+serviceInstance.getPort()+"-"+serviceInstance.getServiceId();
	}
}
