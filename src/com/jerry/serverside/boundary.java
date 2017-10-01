package com.jerry.serverside;

import java.util.ArrayList;

import com.jerry.serverside.entities.calculator.data.CalculatorBean;
import com.jerry.serverside.entities.calculator.data.PossibleOperationBean;

public interface boundary {
	public CalculatorBean emptyCalculatorInstance();
	public ArrayList<PossibleOperationBean> getPossibleOperations(CalculatorBean calculatorBean);
	public CalculatorBean doCompleteCalculation(CalculatorBean calculatorBean);
	public Double doContinousCalculation(CalculatorBean continousBean);
}
