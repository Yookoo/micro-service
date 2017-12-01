package com.microservice.respository;

import java.util.Collection;

/**
 * 
 * @author zhu
 *
 * @param <Restaurant>
 * @param <String>
 */

public interface RestaurantRepository<Restaurant, String> extends Repository<Restaurant, String> {

	boolean containsName(String name) throws Exception;
	
	Collection<Restaurant> findByName (String name) throws Exception;
 }
