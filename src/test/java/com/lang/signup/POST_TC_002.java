package com.lang.signup;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POST_TC_002
{
        @Test	
        public void postcreateuser() 
        {
        	RestAssured.baseURI = "https://reqres.in/api";
        	
        	RequestSpecification createuserhttprequest = RestAssured.given();
        	//{"id":1,"email":"george.bluth@reqres.in","first_name":"George","last_name":"Bluth","avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg"}
        	JSONObject requestparams = new JSONObject();
        	requestparams.put("id", 1);
        	requestparams.put("email", "george.bluth@reqres.in");
        	requestparams.put("first_name", "George");
        	requestparams.put("last_name", "Bluth");
        	requestparams.put("avatar", "https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg");
        	requestparams.put("password", "testing");
        	
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
