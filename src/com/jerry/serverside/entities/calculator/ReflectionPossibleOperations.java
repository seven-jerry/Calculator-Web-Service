package com.jerry.serverside.entities.calculator;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import com.jerry.serverside.entities.calculator.data.PossibleOperationBean;
import com.jerry.serverside.operations.IOperation;

/*
 * this class uses reflection to go over each class in the com.jerry.serverside.operations
 * package and generates a PossibleOperationBean Array which holds possible operation
 * that the user can use 
 * */
public class ReflectionPossibleOperations implements IPossibleOperations {
	private final String PACKAGENAME = "com.jerry.serverside.operations";
	

	@Override
	public  ArrayList<PossibleOperationBean> getPossibleOperaitons() {
	    ArrayList<PossibleOperationBean> possibleOperations = new ArrayList<>();
	    
	    ArrayList<IOperation> operations = this.buildRuntimePossibleOperations(this.PACKAGENAME);
		for(IOperation everyOperation : operations){
			PossibleOperationBean possibleBean = new PossibleOperationBean(everyOperation.getClass().getSimpleName());
			possibleBean.setPrettyPrint(everyOperation.getPrettyPrint());
			possibleBean.setDescription(everyOperation.getDescription());
			possibleOperations.add(possibleBean);
		}
	    return possibleOperations;
	}

	
	private ArrayList<IOperation> buildRuntimePossibleOperations(String packageName) {
		 ArrayList<Class<? extends IOperation>> classes = this.getRuntimeClasses(packageName);
		ArrayList<IOperation> operations = new ArrayList<>();
		
		for(Class<? extends IOperation> everyClass : classes){
			try {
				IOperation operation =  (IOperation) everyClass.newInstance();
				operations.add(operation);
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}		   
		}     
	    return  operations;
	}
	
	private  ArrayList<Class<? extends IOperation>> getRuntimeClasses(String packageName){
		 ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		    assert classLoader != null;
		    ArrayList<Class<?  extends IOperation>> classes = new ArrayList<>();
		    String path = packageName.replace('.', '/');
		    try {
				Enumeration<URL> resources = classLoader.getResources(path);
				List<File> dirs = new ArrayList<File>();
			    while (resources.hasMoreElements()) {
			        URL resource = resources.nextElement();
			        dirs.add(new File(resource.getFile()));
			    }
		
			    for (File directory : dirs) {
			        classes.addAll(this.findClasses(directory, packageName));
			    }
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		    return classes;
	}
	
	
	@SuppressWarnings("unchecked")
	private ArrayList<Class<?  extends IOperation>> findClasses(File directory, String packageName) throws ClassNotFoundException {
		ArrayList<Class<?  extends IOperation>> classes = new ArrayList<Class<?  extends IOperation>>();
	    if (!directory.exists()) {
	        return classes;
	    }
	    File[] files = directory.listFiles();
	    for (File file : files) {
	    		Class<?> classObject = Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6));
	    		if(classObject.isInterface()){
	    			continue;
	    		}
	    		if(IOperation.class.isAssignableFrom(classObject)){ 
	    			classes.add( (Class<? extends IOperation>) classObject);
	    		}
	    }
	    return classes;
	}
	
}
