package com.microservice.controller;

import java.util.ArrayList;
import java.util.Collection;

import javax.websocket.server.PathParam;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.entity.Restaurant;
import com.microservice.service.RestaurantService;
import com.microservice.vo.RestaurantVO;

/**
 * 
 * @author zhu
 *
 */
@RestController
@RequestMapping("/v1/restaurants")
public class RestaurantController {

	protected Logger logger = Logger.getLogger(RestaurantController.class.getName());

	protected RestaurantService restaurantService;

	public RestaurantController(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}
	/**
	 * 获取具有指定名称的餐馆支持不区分大小写的部分匹配
	 * 比如：<code>http://.../v1/restaurants?name=rest</code> 将会找出在其名字中有大小写的'rest'的任何集合；
	 * @param name
	 * @return 返回一个非空的餐馆集合
	 */
	@GetMapping
	public ResponseEntity<Collection<Restaurant>> findByName(@PathParam("name") String name) {

		logger.info(String.format("restaurantService findByName invoked:{} for {}",
				restaurantService.getClass().getName(), name));
		if(name == null ||"".equals(name)) {
			return new ResponseEntity<Collection<Restaurant>>(restaurantService.findAll(), HttpStatus.OK);
		}
		name = name.trim().toLowerCase();
		Collection<Restaurant> restaurants = new ArrayList<>();
		try {
			restaurantService.findByName(name);
		} catch (Exception e) {
			logger.log(Level.WARN, "Exception raised findByName Rest Call", e);
			e.printStackTrace();
			return new ResponseEntity<Collection<Restaurant>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return restaurants.size() > 0 ? new ResponseEntity<Collection<Restaurant>>(restaurants, HttpStatus.OK)
				: new ResponseEntity<Collection<Restaurant>>(HttpStatus.NO_CONTENT);
	}
	/**
	 * 获取具有指定ID的餐馆
	 * 比如：<code>http://.../v1/restaurants/1</code> 将返回ID为'1'的餐馆；
	 * @param id
	 * @return 返回一个非空的餐馆
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Restaurant> findById(@PathVariable("id") Long id){
		
		logger.info(String.format("restaurantService findById invoked:{} for {}",
				restaurantService.getClass().getName(), id));
		Restaurant restaurant = null;
		
		try {
			restaurantService.findById(id);
		} catch (Exception e) {
			logger.log(Level.WARN, "Exception raised findById Rest Call", e);
			e.printStackTrace();
			return new ResponseEntity<Restaurant>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return restaurant != null ? new ResponseEntity<Restaurant>(restaurant, HttpStatus.OK)
				: new ResponseEntity<Restaurant>(HttpStatus.NO_CONTENT);
	
	}
	/**
	 * 添加一个餐馆
	 * 比如：<code>http://.../v1/restaurants</code>
	 * @param restaurant
	 * @return 返回一个非空的餐馆
	 */
	@PostMapping
	public ResponseEntity<Restaurant> add(@RequestBody Restaurant restaurant){
		
		logger.info(String.format("restaurantService add invoked:{} for {}",
				restaurantService.getClass().getName(), restaurant));
		
		try {
			restaurantService.add(restaurant);
		} catch (Exception e) {
			logger.log(Level.WARN, "Exception raised add Rest Call", e);
			e.printStackTrace();
			return new ResponseEntity<Restaurant>(HttpStatus.UNPROCESSABLE_ENTITY);
			
		}
		return new ResponseEntity<Restaurant>(HttpStatus.CREATED);
	}
}
