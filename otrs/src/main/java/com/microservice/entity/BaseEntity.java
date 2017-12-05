package com.microservice.entity;

public abstract class BaseEntity<T> extends Entity<T> {
	
	private T id;
	private String name;
	
	public T getId() {
		return id;
	}
	public void setId(T id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BaseEntity(T id, String name) {
		this.id = id;
		this.name = name;
	}
}
