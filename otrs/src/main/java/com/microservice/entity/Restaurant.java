package com.microservice.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 聚合器 Restaurant
 * @author zhu
 *
 */
public class Restaurant extends BaseEntity<String> {

	private List<Table> tables = new ArrayList<>();

	public Restaurant(String id, String name, List<Table> tables) {
		super(id, name);
		this.tables = tables;
	}

	public List<Table> getTables() {
		return tables;
	}

	public void setTables(List<Table> tables) {
		this.tables = tables;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("id:{},name:{},tables:{}", this.getId(),this.getName(),Arrays.asList(this.getTables())));
		return sb.toString();
	}
	
}
