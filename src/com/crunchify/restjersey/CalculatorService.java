package com.crunchify.restjersey;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.jerry.serverside.Interactor;
import com.jerry.serverside.boundary;
import com.jerry.serverside.entities.calculator.data.CalculatorBean;
import com.jerry.serverside.entities.calculator.data.PossibleOperationBean;



@Path("/api")	
public class CalculatorService {

	//get all the operation which are available threw the server
	//register Client by a clientid
	

	
	@POST
	@Path("/initialize")	
	@Produces("application/json")
	 public  Response getInitialCalculator() {
	  boundary boundary = new Interactor();
	  CalculatorBean bean = boundary.emptyCalculatorInstance();
	 ArrayList<PossibleOperationBean> possibleOperations = boundary.getPossibleOperations(bean);
	 HashMap<String,Object> resultMap = new HashMap<>();
	 resultMap.put("calculator", bean);
	 resultMap.put("possibleOperations", possibleOperations);
	  return Response
	            .status(200)
	            .header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
	            .header("Access-Control-Allow-Credentials", "true")
	            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
	            .header("Access-Control-Max-Age", "1209600")
	            .entity(resultMap)
	            .build();
	}
	
	@POST
	@Path("/completeCalculation")	
	@Produces("application/json")
	@Consumes("application/json")
	 public Response completeCalculation(CalculatorBean bean) {
		boundary boundary = new Interactor();
		boundary.doCompleteCalculation(bean);
		 HashMap<String,Object> resultMap = new HashMap<>();
		 resultMap.put("result", bean.getResult());
		 return Response
		            .status(200)
		            .header("Access-Control-Allow-Origin", "*")
		            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
		            .header("Access-Control-Allow-Credentials", "true")
		            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
		            .header("Access-Control-Max-Age", "1209600")
		            .entity(resultMap)
		            .build();
		  
	}
	
	
	@POST
	@Path("/continousCalculation")	
	@Produces("application/json")
	@Consumes("application/json")
	 public Response continousCalculation(CalculatorBean continousBean) {
		boundary boundary = new Interactor();
		Double result = boundary.doContinousCalculation(continousBean); 
		 HashMap<String,Object> resultMap = new HashMap<>();
		 resultMap.put("result", result);
		 return Response
		            .status(200)
		            .header("Access-Control-Allow-Origin", "*")
		            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
		            .header("Access-Control-Allow-Credentials", "true")
		            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
		            .header("Access-Control-Max-Age", "1209600")
		            .entity(resultMap)
		            .build();
	} 
}