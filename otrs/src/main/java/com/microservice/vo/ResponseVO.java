package com.microservice.vo;

import java.util.Collection;

import com.microservice.entity.Entity;

/**
 * 用于统一REST的返回对象
 * 
 * @author zhu
 *
 */
@SuppressWarnings("hiding")
public class ResponseVO<Entity> {

	private  ResponseStatus responseStatus;
	
	private Collection<Entity> result;

	public ResponseVO(ResponseStatus responseStatus, Collection<Entity> result) {
		super();
		this.responseStatus = responseStatus;
		this.result = result;
	}

	public ResponseVO(ResponseStatus responseStatus) {
		super();
		this.responseStatus = responseStatus;
	}

	@Override
	public String toString() {
		return "ResponseVO [responseStatus=" + responseStatus + ", result=" + result + "]";
	}

	public ResponseStatus getresponseStatus() {
		return responseStatus;
	}

	public void setresponseStatus(ResponseStatus responseStatus) {
		this.responseStatus = responseStatus;
	}

	public Collection<Entity> getResult() {
		return result;
	}

	public void setResult(Collection<Entity> result) {
		this.result = result;
	}
	
}
