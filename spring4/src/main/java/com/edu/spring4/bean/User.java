package com.edu.spring4.bean;

public class User {

	/**
	 * init : user 初始化方法;
	 */
	public void init(){
		System.out.println("---------------user init----------------");
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	private String name;
	private int age;
}
