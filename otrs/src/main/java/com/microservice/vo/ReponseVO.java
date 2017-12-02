package com.microservice.vo;

import java.util.List;

import com.microservice.entity.Entity;

/**
 * 用于统一REST的返回对象
 * 
 * @author zhu
 *
 */
public class ReponseVO<T> {

	private int reponseStatus;
	
	private String message;
	
	private List<Entity<T>> result;

	public ReponseVO(int reponseStatus, String message, List<Entity<T>> result) {
		super();
		this.reponseStatus = reponseStatus;
		this.message = message;
		this.result = result;
	}

	public ReponseVO(int reponseStatus, String message) {
		super();
		this.reponseStatus = reponseStatus;
		this.message = message;
	}

	@Override
	public String toString() {
		return "ReponseVO [reponseStatus=" + reponseStatus + ", message=" + message + ", result=" + result + "]";
	}

	public int getReponseStatus() {
		return reponseStatus;
	}

	public void setReponseStatus(int reponseStatus) {
		this.reponseStatus = reponseStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Entity<T>> getResult() {
		return result;
	}

	public void setResult(List<Entity<T>> result) {
		this.result = result;
	}
	
	
}
