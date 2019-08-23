package com.employeesapi.testcases;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.employeeapi.base.testbase;
import com.employeesapi.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_POSTrecordemployee extends testbase {
	
	String empName = RestUtils.empName();
	String empSalary = RestUtils.empSal();
	String empAge = RestUtils.empAge();
	
	
	@BeforeClass
	public void addemployee() throws InterruptedException {
		
		logger.info("***********************satrted get all employees**************");
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		
		//Creating req object
		 RequestSpecification httprequest = RestAssured.given();
		 
		 
		 logger.info("******************using POSt method************");
		 //creating payload for POST
		 JSONObject requestparams = new JSONObject();
		 
		 requestparams.put("name", empName);
		 requestparams.put("salary", empSalary);
		 requestparams.put("age", empAge);
		 
		 //creating header
		 httprequest.header("Content-Type","application/json");
		 
		 //creating body
		 httprequest.body(requestparams.toJSONString());
		 
		 //Creating using POST method
		Response response = httprequest.request(Method.POST, "/create");
		
		Thread.sleep(3000);
	}
	
	/*@Test
	void checkresponsebody() {
		
		
		String responsebody = response.getBody().asString();
		
		//System.out.println("response body is:"+responsebody);
		//Assertions
				Assert.assertEquals(responsebody.contains(empName),true);
				Assert.assertEquals(responsebody.contains(empSalary),true);
				Assert.assertEquals(responsebody.contains(empAge),true);
				*/
		
	//}
	
	@Test
	void checkstatuscode() {
		
		
		logger.info("*********************************statuscode**********");
		 int statuscode =response.getStatusCode();
		 
		 Assert.assertEquals(statuscode,200);
	}
	
	 @AfterClass
	   void teardpwn() {
		   
		   logger.info("*******************closed the testcase**************");
	   }
}