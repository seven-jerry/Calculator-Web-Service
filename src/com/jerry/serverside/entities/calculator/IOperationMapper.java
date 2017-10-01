package com.jerry.serverside.entities.calculator;

import java.util.LinkedList;

import com.jerry.serverside.entities.calculator.data.IMapableOperation;
import com.jerry.serverside.operations.IOperation;

public interface IOperationMapper {
	public LinkedList<IOperation> mapOperationsToOperationChain(IMapableOperation inputOperation);	
}
