package com.jerry.serverside.operations;
/*
 * this interface should only be implemented by the classes which should be
 * each class that is in this package and implements the IOperation interface will
 * get provided to the user threw a possible operation
 */
public interface IOperation {
	Double doCalculation(Double baseValue);
	void setNumber(Double number);
	Double getNumber();
	String getPrettyPrint();
	String getDescription();
}
