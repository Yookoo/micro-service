package com.microservice.respository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.microservice.App;
import com.microservice.entity.Restaurant;

import junit.framework.TestCase;
/**
 * InMemRestaurantRepository 单元测试
 * @author zhu
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
//@SpringApplicationConfiguration(classes = App.class) // 指定我们SpringBoot工程的Application启动类
//@WebAppConfiguration
public class InMemRestaurantRepositoryTest {

	@Autowired
	private InMemRestaurantRepository restaurantRepository;
	/**
	 * 初始化 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.testAdd();
		this.testAdd();
		this.testAdd();
		this.testAdd();
	}

	@Test
	public void testAdd() {
		Restaurant restaurant = new Restaurant("Big-O Restaurant",null);
		restaurantRepository.add(restaurant);
		restaurant = new Restaurant("O Restaurant",null);
		restaurantRepository.add(restaurant);
		TestCase.assertTrue(restaurantRepository.getAll().size()>0);
	}

	@Test
	public void testUpdate() {
		Restaurant restaurant = new Restaurant(2L,"牛排家",null);
		restaurantRepository.update(restaurant);
		TestCase.assertEquals("牛排家",restaurantRepository.get(2L).getName());
	}

	@Test
	public void testRemove() {
		restaurantRepository.remove(3L);
	}

	@Test
	public void testGet() {
		TestCase.assertNotNull(restaurantRepository.get(1L));
		
	}

	@Test
	public void testGetAll() {
		TestCase.assertNotNull(restaurantRepository.getAll());
	}

	@Test
	public void testFindByName() throws Exception {
		TestCase.assertNotNull(restaurantRepository.findByName("Big-O Restaurant"));
	}
	
	@Test
	public void testContainsName() {
		TestCase.assertNotNull(restaurantRepository.containsName("Big-O"));
	}

}
