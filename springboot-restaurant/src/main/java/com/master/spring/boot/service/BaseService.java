package com.master.spring.boot.service;

import java.util.Collection;

import com.master.spring.boot.respository.Respository;

public abstract class BaseService<TE, T> extends ReadOnlyBaseService<TE, T>{
	
	private Respository<TE, T> _respository;

	BaseService(Respository<TE, T> respository) {
		super(respository);
		_respository = respository;
	}

	public void add(TE entity) throws Exception{
		_respository.add(entity);
	}
	
	public Collection<TE> getAll() {
		return _respository.getAll();
 	}
}
