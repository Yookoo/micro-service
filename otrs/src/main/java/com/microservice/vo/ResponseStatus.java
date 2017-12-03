package com.microservice.vo;

public enum ResponseStatus {
	SUCCESS(200,"操作成功"),FAILURE(400,"操作失败"){
		
	};
	int status;
	String message;
	private ResponseStatus(int status,String message) {
        this.status = status;
        this.message = message;
    }
}
