package com.master.spring.boot.domain;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Restaurant extends BaseEntity<BigInteger> {

	private List<Table> tables = new ArrayList<>();
	
	public Restaurant(BigInteger id, String name, List<Table> tables) {
		super(id, name);
		this.tables = tables;
	}

	public List<Table> getTables() {
		return tables;
	}

	public void setTables(List<Table> tables) {
		this.tables = tables;
	}
	
	
}
