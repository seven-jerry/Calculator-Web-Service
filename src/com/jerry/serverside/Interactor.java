package com.jerry.serverside;


import java.util.ArrayList;

import com.jerry.serverside.entities.calculator.CalculatorEntity;
import com.jerry.serverside.entities.calculator.ICalculatorEntity;
import com.jerry.serverside.entities.calculator.data.CalculatorBean;
import com.jerry.serverside.entities.calculator.data.PossibleOperationBean;

public class Interactor implements boundary {
	
	//injectable
	private ICalculatorEntity calculatorEntity;	
	public Interactor(){
		this.calculatorEntity = CalculatorEntity.getInstance();
	}
	@Override
	public CalculatorBean emptyCalculatorInstance() {
		CalculatorBean emptyInstance = this.calculatorEntity.getEmptyBean();
		return emptyInstance;
	}
	@Override
	public ArrayList<PossibleOperationBean> getPossibleOperations(CalculatorBean calculatorBean) {
		return this.calculatorEntity.getPossibleOperations();
	}
	@Override
	public CalculatorBean doCompleteCalculation(CalculatorBean calculatorBean) {
		return this.calculatorEntity.doCompleteCalculation(calculatorBean);
	}
	@Override
	public Double doContinousCalculation(CalculatorBean continousBean) {
		return this.calculatorEntity.doContinousCalculation(continousBean);
	}

}
