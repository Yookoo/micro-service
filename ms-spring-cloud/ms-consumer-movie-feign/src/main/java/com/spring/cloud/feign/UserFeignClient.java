package com.spring.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.cloud.entity.User;
/**
 * FeignClient
 * @author Administrator
 *
 */
@FeignClient("ms-provider-user")
public interface UserFeignClient {
	/**
	 * 注意两个坑:  1. FeignClient 不支持  @GetMapping 注解
	 * 需要使用 	@RequestMapping(value= "/user/{id}", method= RequestMethod.GET) 代替;
	 *  2. public User findById(@PathVariable("id") Long id);
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value= "/user/{id}", method= RequestMethod.GET)
    public User findById(@PathVariable("id") Long id);

}
