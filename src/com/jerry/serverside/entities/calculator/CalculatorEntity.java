package com.jerry.serverside.entities.calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import com.jerry.serverside.entities.calculator.data.CalculatorBean;
import com.jerry.serverside.entities.calculator.data.PossibleOperationBean;
import com.jerry.serverside.operations.IOperation;

public class CalculatorEntity implements ICalculatorEntity {
	private Integer clientIds = 0; 
	private IPossibleOperations possibleOperations;
	private IOperationMapper operationMapper;
	private HashMap<Integer,CalculatorBean> clientBeans;
	private static CalculatorEntity instance = null;
	   protected CalculatorEntity() {
	      // Exists only to defeat instantiation.
		   clientBeans = new HashMap<>();
	   }
	   public static CalculatorEntity getInstance() {
	      if(instance == null) {
	         instance = new CalculatorEntity();
	      }
	      return instance;
	   }
	@Override
	public CalculatorBean getEmptyBean() {
		this.clientIds ++;
		CalculatorBean emptyBean = new CalculatorBean(this.clientIds);
		return emptyBean;
	}
	
	@Override
	public  ArrayList<PossibleOperationBean> getPossibleOperations() {
		this.possibleOperations = new ReflectionPossibleOperations();
		return this.possibleOperations.getPossibleOperaitons();
	}
	
	@Override
	public CalculatorBean doCompleteCalculation(CalculatorBean calculatorBean) {
		this.operationMapper = new ReflectionOperationMapper();
		LinkedList<IOperation> operationChain =  this.operationMapper.mapOperationsToOperationChain(calculatorBean);
		calculatorBean.addOperationChainToChain(operationChain);
		calculatorBean = this.calculateOperationChain(calculatorBean);
		this.printOperationChain(calculatorBean);
		clientBeans.put(calculatorBean.getClientId(), calculatorBean);
		return calculatorBean;
	}
	
	
	@Override
	public Double doContinousCalculation(CalculatorBean continousBean) {
		this.operationMapper = new ReflectionOperationMapper();
		LinkedList<IOperation> operationChain = this.operationMapper.mapOperationsToOperationChain(continousBean);
		continousBean.addOperationChainToChain(operationChain);
		CalculatorBean clientBean = this.clientBeans.get(continousBean.getClientId());
		if(clientBean == null){
			return -1.0;
		}
		clientBean = this.calculateContinousOperationChain(clientBean,continousBean);
		this.printOperationChain(clientBean);
		return clientBean.getResult();
	}
	
	
	private CalculatorBean calculateOperationChain(CalculatorBean calculatorBean){
	       Double runningResult = calculatorBean.getFirstNumber();
	       for(IOperation everyOperation : calculatorBean.getOperationChain()){
	           runningResult = everyOperation.doCalculation(runningResult);
	       }
	       calculatorBean.setResult(runningResult);
	       return calculatorBean;
	    }
	    
	
	private CalculatorBean calculateContinousOperationChain(CalculatorBean clientBean,CalculatorBean continousBean){
	       Double runningResult = clientBean.getResult();
	       for(IOperation everyOperation : continousBean.getOperationChain()){
	           runningResult = everyOperation.doCalculation(runningResult);
	       }
	       clientBean.setResult(runningResult);
	       clientBean.addOperationChainToChain(continousBean.getOperationChain());

	       return clientBean;
	    }
	    
	
	private void printOperationChain(CalculatorBean calculatorBean){
	        System.out.print(calculatorBean.getFirstNumber());
	        System.out.print(" ");
	        for(IOperation everyOperation : calculatorBean.getOperationChain()){
	            System.out.print(everyOperation.toString());
	        }
	        System.out.print(" = ");
	        System.out.println(calculatorBean.getResult());
	    }
	
}
