package com.jerry.serverside.entities.calculator.data;
import java.util.ArrayList;
import java.util.LinkedList;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.jerry.serverside.operations.IOperation;


public class CalculatorBean implements IMapableOperation {
	@JsonIgnore LinkedList<IOperation> operationChain;
     Double firstNumber;
     Double resultNumber;
     Integer clientId;
	 ArrayList<IKeyValueBean> operations;
     
     public CalculatorBean(){
    	 
     }
     
    public CalculatorBean(Integer newClientId) {
    	this.clientId = newClientId;
        this.operationChain = new LinkedList<IOperation>();
        this.operations = new ArrayList<>();
        this.firstNumber = 0.0;
        this.resultNumber = 0.0;
    }

 
    public Integer getClientId(){
        return this.clientId;
    }
    public void setClientId(Integer clientId){
    	this.clientId = clientId;
    }
    
  //sets the very first Number in the Calculator
    public void setFirstNumber(Double firstNumber){
        this.firstNumber = firstNumber;
    }
    public Double getFirstNumber(){
        return this.firstNumber;
    }
    
    @Override
    public ArrayList<IKeyValueBean> getOperations(){
    	return this.operations;
    }
    public void setOperations(ArrayList<IKeyValueBean> operations){
    	this.operations = operations;
    }
    public void clearOperations(){
    	this.operations = new ArrayList<>();
    }
    public Double getResult(){
    	return this.resultNumber;
    }
    public void setResult(Double result){
    	this.resultNumber = result;
    }
    public void addOperationToChain(IOperation operation){
        this.operationChain.add(operation);
    }
    public void addOperationChainToChain(LinkedList<IOperation> otherOperationChain){
    	this.operationChain.addAll(otherOperationChain);
    }
    public LinkedList<IOperation> getOperationChain(){
    	if(this.operationChain == null){
    		this.operationChain = new LinkedList<IOperation>();
    	}
    	return this.operationChain;
    }
}
