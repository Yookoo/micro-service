package com.master.spring.boot.service;

import com.master.spring.boot.domain.Restaurant;
import com.master.spring.boot.respository.RestaurantRespository;

public abstract class RestaurantService extends BaseService<Restaurant, String>{
	
	private RestaurantRespository restaurantRespoistory;

	RestaurantService(RestaurantRespository respository) {
		super(respository);
		this.restaurantRespoistory = respository;
	}

	public void add(Restaurant restaurant) throws Exception{
		if(restaurantRespoistory.ContainsName(restaurant.getName())){
			throw new Exception(String.format("There is already a product with the name - %s", restaurant.getName()));
		}
		
		if(restaurant.getName() == null || "".equals(restaurant.getName())){
			throw new Exception("Restarant name cannot be null or empty string.");
		}
		super.add(restaurant);
	}
	
}
