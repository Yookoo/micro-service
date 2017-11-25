package com.master.spring.boot.domain;

import java.math.BigInteger;

/**
 * 桌子实体
 * 
 * @author ZKY
 *
 */

public class Table extends BaseEntity<BigInteger> {

	//容量
	private int capacity;

	
	
	public Table(BigInteger id, String name, int capacity) {
		super(id, name);
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	
}
