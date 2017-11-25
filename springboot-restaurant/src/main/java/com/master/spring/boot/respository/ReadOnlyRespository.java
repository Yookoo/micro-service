package com.master.spring.boot.respository;

import java.util.Collection;

import com.master.spring.boot.domain.Entity;

/**
 * 只读资源库
 * @author ZKY
 *
 * @param <TE>
 * @param <T>
 */
public interface ReadOnlyRespository<TE, T> {

	boolean contains(T id);
	
	Entity<T> get(T id);
	
	Collection<TE> getAll();
}
