package com.jerry.serverside.entities.calculator.data;

import java.util.ArrayList;

public interface IMapableOperation {
	public ArrayList<IKeyValueBean> getOperations();
	public void clearOperations();
}
