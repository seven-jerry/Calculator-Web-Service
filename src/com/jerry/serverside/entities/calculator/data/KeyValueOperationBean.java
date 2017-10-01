package com.jerry.serverside.entities.calculator.data;

public class KeyValueOperationBean implements IKeyValueBean {
	private String key;
	private Double value;
	public KeyValueOperationBean() {
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	
	
}
