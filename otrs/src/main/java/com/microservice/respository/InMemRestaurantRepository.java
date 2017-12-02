package com.microservice.respository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.microservice.entity.Entity;
import com.microservice.entity.Restaurant;


@Repository("restaurantRepository")
public class InMemRestaurantRepository implements RestaurantRepository<Restaurant, Long> {

	private AtomicLong primaryKey= new AtomicLong(0); 
	private Map<Long, Restaurant> entities = new ConcurrentHashMap<>();
	
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
		long key = primaryKey.incrementAndGet();
		entity.setId(key);
		entities.put(key, entity);
	}

	@Override
	public void update(Restaurant entity) {
		if(entities.containsKey(entity.getId())) {
			entities.put(entity.getId(),entity);
		}
	}

	@Override
	public void remove(Long id) {
		if(entities.containsKey(id)) {
			entities.remove(id);
		}
	}

	@Override
	public boolean contains(Long id) {
		throw new UnsupportedOperationException("contains 方法暂未实现");
	}

	@Override
	public Entity<Long> get(Long id) {
		return entities.get(id);
	}

	@Override
	public Collection<Restaurant> getAll() {
		return entities.values();
	}


	@Override
	public Collection<Restaurant> findByName(String name) throws Exception {
		Collection<Restaurant> restaurants =new ArrayList<>();
		entities.forEach((k,v) ->{
			if(v.getName().toLowerCase().equals(name)) {
				restaurants.add(v);
			}
		});
		return restaurants;
	}

	@Override
	public Collection<Restaurant> findByNameLike(String name) throws Exception {
		Collection<Restaurant> restaurants =new ArrayList<>();
		int noOfChars = name.length();
		//TODO lamada 表达式
		/**
		 * 1.遍历Map中的所有的餐馆
		 * 2.如果餐馆名字中包含传入的字符串
		 * 3.将其加入List返回
		 */
		entities.forEach((k,v) ->{
			if(v.getName().toLowerCase().contains(name.subSequence(0, noOfChars))) {
				restaurants.add(v);
			}
		});
		return restaurants;
	}


}
