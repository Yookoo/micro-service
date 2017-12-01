package com.microservice.respository;

public interface Repository<TE, T> extends ReadOnlyRepository<TE, T> {

	void add(TE entity);
	
	void update(TE entity);
	
	void remove(T id);
}
