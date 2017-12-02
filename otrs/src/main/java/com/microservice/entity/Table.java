package com.microservice.entity;

/**
 * Table 实体
 * @author zhu
 *
 */
public class Table extends Entity<Long> {

	private int capacity;//容量

	public Table(Long id, String name, int capacity) {
		super(id, name);
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("id:{},name:{},capacity:{}", this.getId(),this.getName(),this.getCapacity()));
		return sb.toString();
	}
	
}
