package com.microservice.respository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.microservice.entity.Entity;
import com.microservice.entity.Restaurant;
@Repository("restaurantRepository")
public class InMemRestaurantRepository implements RestaurantRepository<Restaurant, String> {

	private Map<String, Restaurant> entities;
	
	
	public InMemRestaurantRepository() {
		this.entities = new HashMap<>();
		Restaurant restaurant = new Restaurant("Big-O Restaurant","1",null);
		entities.put("1", restaurant);
		restaurant = new Restaurant("O Restaurant","2",null);
		entities.put("2", restaurant);
	}

	
	@Override
	public boolean containsName(String name) {
		try {
			return this.findByName(name).size() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void add(Restaurant entity) {
		entities.put(entity.getId(), entity);
	}

	@Override
	public void update(Restaurant entity) {
		if(entities.containsKey(entity.getId())) {
			entities.put(entity.getId(),entity);
		}
		
	}

	@Override
	public void remove(String id) {
		if(entities.containsKey(id)) {
			entities.remove(id);
		}
	}

	@Override
	public boolean contains(String id) {
		throw new UnsupportedOperationException("contains 方法暂未实现");
	}

	@Override
	public Entity<String> get(String id) {
		return entities.get(id);
	}

	@Override
	public Collection<Restaurant> getAll() {
		return entities.values()  ;
	}


	@Override
	public Collection<Restaurant> findByName(String name) throws Exception {
		Collection<Restaurant> restaurants =new ArrayList<>();
		int noOfChars = name.length();
		//TODO lamada 表达式
		entities.forEach((k,v) ->{
			if(v.getName().toLowerCase().contains(name.subSequence(0, noOfChars))) {
				restaurants.add(v);
			}
		});
		return restaurants;
	}


}
