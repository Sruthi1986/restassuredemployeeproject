package com.employeesapi.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {

	
	public static String empName(){
		
		String generatestring = RandomStringUtils.randomAlphabetic(1);
		return("john"+generatestring);
	}
	
	public static String empSal() {
		
		String generatestring = RandomStringUtils.randomNumeric(5);
		return(generatestring);
		
	}
	
	public static String empAge() {
		String generatestring = RandomStringUtils.randomNumeric(2);
		return(generatestring);
	}
}
