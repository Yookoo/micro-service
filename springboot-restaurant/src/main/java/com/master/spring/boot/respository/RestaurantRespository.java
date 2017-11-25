package com.master.spring.boot.respository;

import java.math.BigInteger;

import com.master.spring.boot.domain.Restaurant;


/**
 * 
 * 
 * @author ZKY
 *
 */
public interface RestaurantRespository extends Respository<Restaurant, String>{

	boolean ContainsName(String name);
	
}
