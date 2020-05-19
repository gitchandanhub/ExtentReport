package com.sfmc.reports;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GET_TC_001 
{

	@Test
	public void getweatherdetail()
	{
		//Specify base uri
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		
		// request object (get the request specification of the request that you want to sent to the server)
		RequestSpecification weatherhttpreqest = RestAssured.given();
		
		
		// Response object
		
		Response  weatherhttpresonse = weatherhttpreqest.request(Method.GET, "/delhi");
		
		System.out.println("the time is == " +weatherhttpresonse.getTimeIn(TimeUnit.SECONDS));
		
		//Print response received from the server
		String responsebody = weatherhttpresonse.asString();
		
		//Print response received from the server
		//String responsebody = weatherhttpresonse.getBody().asString();   //convert json format to string body
		
		System.out.println("Response body == "  + responsebody);
		
		//status code validation
		int stauscode = weatherhttpresonse.getStatusCode();		
		
		System.out.println("status code==" +stauscode );
		
		Assert.assertEquals(stauscode, 200);
		
		//status line validation
		String statusline = weatherhttpresonse.getStatusLine();
		System.out.println("status line==" +statusline );
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
	}
}
