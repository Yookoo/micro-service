package com.edu.entity;

public enum ActionType {
	INSERT(1,"增加"),
	UPDATE(2,"修改"),
	DELETE(3,"删除");
	
	private int index;
	private String name;
	
	private ActionType(int index, String name) {
		this.index = index;
		this.name = name;
	}
	
	
}
