package com.employeeapi.base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class testbase {
	
	public static RequestSpecification httprequest;
	public static Response response;
	public String empID = "58339";
	 public Logger logger;
	 
	 
	 @BeforeClass
	 public void setup() {
		 
		 logger = Logger.getLogger("EmployeesRestAPI");
		 PropertyConfigurator.configure("log4j.properties");
		 logger.setLevel(Level.DEBUG);	 }

}
