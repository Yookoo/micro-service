package com.master.spring.boot.respository;

/**
 * 资源库
 * @author ZKY
 *
 * @param <TE>
 * @param <T>
 */
public interface Respository<TE, T> extends ReadOnlyRespository<TE, T>{

	void add(TE entity);
	
	void remove(T id);
	
	void update(TE entity);
}
