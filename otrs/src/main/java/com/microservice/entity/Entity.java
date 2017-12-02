package com.microservice.entity;
/**
 * 实体类的基类 Entity
 * @author zhu
 *
 * @param <T>
 */
public abstract class Entity<T> {

	private T id;
	private String name;
	public Entity(T id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Entity() {
		super();
	}
	
	public Entity(String name) {
		super();
		this.name = name;
	}
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
	
}
