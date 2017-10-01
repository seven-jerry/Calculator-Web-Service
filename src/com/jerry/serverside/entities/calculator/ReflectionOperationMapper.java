package com.jerry.serverside.entities.calculator;

import java.util.LinkedList;

import com.jerry.serverside.entities.calculator.data.IKeyValueBean;
import com.jerry.serverside.entities.calculator.data.IMapableOperation;
import com.jerry.serverside.operations.IOperation;

public class ReflectionOperationMapper implements IOperationMapper {
	private final String PACKAGENAME = "com.jerry.serverside.operations";

	public ReflectionOperationMapper(){}
	@Override
	public LinkedList<IOperation> mapOperationsToOperationChain(IMapableOperation inputOperation ) {
		LinkedList<IOperation> resultArray = new LinkedList<>();
		for(IKeyValueBean keyValueOperation : inputOperation.getOperations()){
			IOperation operation =  this.getOperationFromKey(keyValueOperation.getKey());
			operation.setNumber(keyValueOperation.getValue());
			resultArray.add(operation);
		}
		inputOperation.clearOperations();
		return resultArray;
	}
	
	
	private IOperation getOperationFromKey(String key){
		String className = String.format("%s.%s", this.PACKAGENAME,key);
		IOperation operation = null;
		try {
			Class<?> clazz = Class.forName(className);
			operation =  (IOperation) clazz.newInstance();
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return operation;
		
	}

}
