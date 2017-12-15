package com.edu.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class Action {
	
	private Long id;
	
	private Object objId;
	private String objClass;
	private String operator;
	private Date  operatorTime;
	private ActionType actionType;
	private List<ChangeItem> changes = new ArrayList<>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Object getObjId() {
		return objId;
	}
	public void setObjId(Object objId) {
		this.objId = objId;
	}
	public String getObjClass() {
		return objClass;
	}
	public void setObjClass(String objClass) {
		this.objClass = objClass;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public Date getOperatorTime() {
		return operatorTime;
	}
	public void setOperatorTime(Date operatorTime) {
		this.operatorTime = operatorTime;
	}
	public ActionType getActionType() {
		return actionType;
	}
	public void setActionType(ActionType actionType) {
		this.actionType = actionType;
	}
	public List<ChangeItem> getChanges() {
		return changes;
	}
	public void setChanges(List<ChangeItem> changes) {
		this.changes = changes;
	}
	
	
}
