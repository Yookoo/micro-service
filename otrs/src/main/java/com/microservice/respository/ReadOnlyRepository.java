package com.microservice.respository;


import java.util.Collection;
import java.util.List;

import com.microservice.entity.Entity;
import com.microservice.entity.Restaurant;

/**
 * 只读的存储库
 * @author zhu
 *
 * @param <TE> 实体
 * @param <T> 主键
 */
public interface ReadOnlyRepository<TE,T> {
	/**
	 * 包含
	 * @param id
	 * @return
	 */
	boolean contains(T id);
	
	Entity<T> get(T id);
	
	Collection<TE> getAll();
}
