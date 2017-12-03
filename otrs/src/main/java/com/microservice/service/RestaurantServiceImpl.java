package com.microservice.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.entity.Entity;
import com.microservice.entity.Restaurant;
import com.microservice.respository.InMemRestaurantRepository;
import com.microservice.respository.RestaurantRepository;

@Service("restaurantService")
public class RestaurantServiceImpl implements RestaurantService {
	
	@Autowired
	private RestaurantRepository<Restaurant,Long> restaurantRepository;
	
	@Override
	public void add(Restaurant restaurant) throws Exception {
		if(restaurant.getName() == null || "".equals(restaurant.getName())) {
			throw new Exception("餐馆名称不能为null或者空字符串");
		}
		if(restaurantRepository.containsName(restaurant.getName())) {
			throw new Exception(String.format("餐馆名称已存在: - %s", restaurant.getName()));
		}
		restaurantRepository.add(restaurant);
	}

	@Override
	public void update(Restaurant restaurant) throws Exception {
		if(restaurant.getName() == null || "".equals(restaurant.getName())) {
			throw new Exception("餐馆名称不能为null或者空字符串");
		}
		if(restaurantRepository.containsName(restaurant.getName())) {
			throw new Exception(String.format("餐馆名称已存在: - %s", restaurant.getName()));
		}
		restaurantRepository.update(restaurant);

	}

	@Override
	public void delete(Long id) throws Exception {
		restaurantRepository.remove(id);
	}

	@Override
	public Restaurant findById(Long id) throws Exception {
		return (Restaurant) restaurantRepository.get(id);
	}

	@Override
	public Collection<Restaurant> findByName(String name) throws Exception {
		return restaurantRepository.findByName(name);

	}

	@Override
	public void findByCriteria(Map<String, ArrayList<String>> name) throws Exception {
		throw new UnsupportedOperationException("findByCriteria方法暂未实现");
	}

	@Override
	public Collection<Restaurant> findAll() {
		return restaurantRepository.getAll();
	}

	@Override
	public Collection<Restaurant> findByNameLike(String name) throws Exception {
		return restaurantRepository.findByNameLike(name);
	}

}
