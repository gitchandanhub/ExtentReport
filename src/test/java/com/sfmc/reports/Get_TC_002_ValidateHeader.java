package com.sfmc.reports;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get_TC_002_ValidateHeader 
{
	@Test
	public void headervalidate()
	{
		//Specify base uri
		RestAssured.baseURI = "https://maps.gooogleapis.com";
		
		// request object (get the request specification of the request that you want to sent to the server)
		RequestSpecification weatherhttpreqest = RestAssured.given();
		
		
		// Response object
		
		Response  weatherhttpresonse = weatherhttpreqest.request(Method.GET, "maps/api/js?key=YOUR_API_KEY&callback=initMap");
		
		System.out.println("the time is == " +weatherhttpresonse.getTimeIn(TimeUnit.SECONDS));
		
		//Print response received from the server
		String responsebody = weatherhttpresonse.asString();
		
		//Print response received from the server
		//String responsebody = weatherhttpresonse.getBody().asString();   //convert json format to string body
		
	//	System.out.println("Response body == "  + responsebody);
		
		//status code validation
		int stauscode = weatherhttpresonse.getStatusCode();		
		
		System.out.println("status code==" +stauscode );
		
		String head= weatherhttpresonse.header("Content-Type");
		
		System.out.println(head);
		
		//System.out.println(weatherhttpresonse.headers().asList());
	}
}
