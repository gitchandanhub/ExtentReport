package com.lang.signup;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post_TC_001 
{
        @Test	
        public void postcreateuser() 
        {
        	RestAssured.baseURI = "http://restapi.demoqa.com/customer";
        	
        	RequestSpecification createuserhttprequest = RestAssured.given();
        	
        	JSONObject requestparams = new JSONObject();
        	requestparams.put("FirstName", "Chandan");
        	requestparams.put("Lastname", "Singh");
        	requestparams.put("UserName", "cchauhan32");
        	requestparams.put("Password", "test@123");
        	requestparams.put("Email", "cchauhan281188@gmail.com");
        	
        	createuserhttprequest.header("Content-Type", "application/json");
        	createuserhttprequest.body(requestparams.toJSONString());
        	
        	Response createuserresponse = createuserhttprequest.post("/register");
        	
        	//Response createuserresponse = createuserhttprequest.request(Method.POST, "/register");
        	
        	String response = createuserresponse.getBody().asString();
        	
        	System.out.println("Response body == " +response);
        	
        	int statuscode = createuserresponse.getStatusCode();
        	
        	System.out.println("Response code == " +statuscode);
        	
        	String successcode = createuserresponse.jsonPath().get("SuccessCode");
        	
        	
        	System.out.println("Success code" +successcode );
        }
}
