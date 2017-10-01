package com.jerry.serverside.entities.calculator;

import java.util.ArrayList;

import com.jerry.serverside.entities.calculator.data.CalculatorBean;
import com.jerry.serverside.entities.calculator.data.PossibleOperationBean;

public interface ICalculatorEntity {
	public CalculatorBean getEmptyBean();
	public  ArrayList<PossibleOperationBean> getPossibleOperations();
	public CalculatorBean doCompleteCalculation(CalculatorBean calculatorBean);
	public Double doContinousCalculation(CalculatorBean continousBean);

}
