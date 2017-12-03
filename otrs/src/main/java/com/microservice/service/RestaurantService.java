package com.microservice.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import com.microservice.entity.Entity;
import com.microservice.entity.Restaurant;

public interface RestaurantService {
	
	void add(Restaurant restaurant) throws Exception;
	void update(Restaurant restaurant) throws Exception;

	Restaurant findById(Long id) throws Exception;
	Collection<Restaurant> findByName(String name) throws Exception;
	void findByCriteria(Map<String,ArrayList<String>> name) throws Exception;
	Collection<Restaurant> findAll()throws Exception;
	void delete(Long id) throws Exception;
	Collection<Restaurant> findByNameLike(String name) throws Exception;
}
