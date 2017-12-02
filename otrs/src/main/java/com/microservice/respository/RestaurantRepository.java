package com.microservice.respository;

import java.util.Collection;

/**
 * 
 * @author zhu
 *
 * @param <Restaurant>
 * @param <String>
 */

public interface RestaurantRepository<Restaurant, Long> extends Repository<Restaurant, Long> {

	boolean containsName(String name) throws Exception;
	
	Collection<Restaurant> findByName (String name) throws Exception;
	
	Collection<Restaurant> findByNameLike (String name) throws Exception;
 }
