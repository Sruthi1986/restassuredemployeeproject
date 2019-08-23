package com.employeesapi.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.testbase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;

public class TC001_Get_all_employees extends testbase {
	
	@BeforeClass
   public void getallemployees() {
	   
		logger.info("***********************satrted get all employees**************");
	   RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		
		//Creating req object
		  httprequest = RestAssured.given();
		  
		  logger.info("******************using GEt method************");
		  response = httprequest.request(Method.GET,"/employees");
		 
   }
   
   @Test
   void checkresponsebody() {
	   
	  String responsebody =  response.getBody().asString();
	  System.out.println(responsebody);
	  logger.info("******************using Assertions**********");
	  Assert.assertTrue(responsebody!=null);
	  
	   
   }
   
   @Test
   void checkstatus() {
	   
	   logger.info("*****************ststuscode***************");
	   int ststuscode = response.getStatusCode();
	   
	   logger.info("**********************assertions*************");
	   Assert.assertEquals(ststuscode, 200);
   }
   
   @Test
   void checkresponsetime() {
	   
	   long statustime = response.getTime();
	   
	   if(statustime>2000) 		   
	     logger.warn("response time is greater than 2000");
	   
	   Assert.assertTrue(statustime<2000);
   }
}
