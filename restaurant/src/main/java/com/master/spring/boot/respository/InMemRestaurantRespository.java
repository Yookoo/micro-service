package com.master.spring.boot.respository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.master.spring.boot.domain.Entity;
import com.master.spring.boot.domain.Restaurant;

public class InMemRestaurantRespository implements RestaurantRespository{

	//
	private Map<String, Restaurant> entities;
	
	
	public InMemRestaurantRespository() {
		this.entities = new HashMap<>() ;
	}	

	@Override
	public boolean ContainsName(String name) {
		return entities.containsKey(name);
	}
	
	@Override
	public void add(Restaurant entity) {
		entities.put(entity.getName(), entity);
	}
	/**
	 * 有问题(其他的key都是name，这个怎么成id了)	
	 */
	@Override
	public void remove(String id) {
		if(entities.containsKey(id)){
			entities.remove(id);
		}
	}
	@Override
	public void update(Restaurant entity) {
		if(entities.containsKey(entity.getName())){
			entities.put(entity.getName(), entity);
		}
	}

	@Override
	public boolean contains(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Entity<String> get(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Collection<Restaurant> getAll() {
		return entities.values();
	}

}
