package com.microservice.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.microservice.App;
import com.microservice.entity.Restaurant;
import com.microservice.service.RestaurantServiceImpl;

import junit.framework.TestCase;
/**
 * RestaurantServiceImpl 单元测试
 * @author zhu
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class RestaurantServiceImplTest {
	
	@Autowired
	private RestaurantServiceImpl restaurantService;
	

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testAdd() throws Exception{
		
		Restaurant restaurant = new Restaurant("烩面", null);
		restaurantService.add(restaurant);
	
	}
	@Test
	public void testUpdate() throws Exception{
		Restaurant restaurant = new Restaurant("烩面1", null);
		restaurantService.add(restaurant);
		restaurant = new Restaurant(1L,"串串香", null);
		restaurantService.update(restaurant);
	};
	@Test
	public void testFindById() throws Exception{
		Restaurant restaurant = new Restaurant("烩面2", null);
		restaurantService.add(restaurant);
		TestCase.assertNotNull(restaurantService.findById(1L));
	};
	@Test
	public void testFindByName() throws Exception {
		Restaurant restaurant = new Restaurant("烩面3", null);
		restaurantService.add(restaurant);
		TestCase.assertNotNull(restaurantService.findByName("烩面"));
	};
	@Test
	public void testFindAll(){
		TestCase.assertNotNull(restaurantService.findAll());
	};
	
	@Test
	public void testDelete() throws Exception{
		Restaurant restaurant = new Restaurant("烩面4", null);
		restaurantService.add(restaurant);
		restaurantService.delete(2L);
	};

}
