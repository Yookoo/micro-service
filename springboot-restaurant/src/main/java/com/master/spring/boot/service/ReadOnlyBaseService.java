package com.master.spring.boot.service;

import com.master.spring.boot.respository.Respository;

public abstract class ReadOnlyBaseService<TE, T> {
	
	private Respository<TE, T> respository;

	ReadOnlyBaseService(Respository<TE, T> respository) {
		this.respository = respository;
	}

}
