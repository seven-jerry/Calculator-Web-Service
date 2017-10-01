package com.jerry.serverside.entities.calculator.data;

public class PossibleOperationBean {
	private String key;
	private String prettyPrint;
	private String description;
	
	public PossibleOperationBean(String key){
		this.key = key;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getPrettyPrint() {
		return prettyPrint;
	}
	public void setPrettyPrint(String prettyPrint) {
		this.prettyPrint = prettyPrint;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString(){
		return String.format("%s %s",this.getKey(),this.getPrettyPrint());
	}
	
}
 