package com.jerry.serverside.entities.calculator.data;

import java.util.ArrayList;

public class ContinousCalculatorBean {
	private Integer clientId;
	private ArrayList<KeyValueOperationBean> operations;
	public ContinousCalculatorBean() {
	}
	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	public ArrayList<KeyValueOperationBean> getOperations() {
		return operations;
	}
	public void setOperations(ArrayList<KeyValueOperationBean> operations) {
		this.operations = operations;
	}

}
