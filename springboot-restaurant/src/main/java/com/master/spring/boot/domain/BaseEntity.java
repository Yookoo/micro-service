package com.master.spring.boot.domain;

/**
 * 基类
 * 
 * @author ZKY
 *
 * @param <T>
 */
public abstract class BaseEntity<T> extends Entity<T>{

	private T id;

	public BaseEntity(T id, String name) {
		super.id = id;
		super.name = name;
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
