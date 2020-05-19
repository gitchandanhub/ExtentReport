package com.lang.modification;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PatchDemo
{
	@Test
	public void updatedata()
	{
	RestAssured.baseURI = "http://localhost:3000";
    RequestSpecification httppatchrequest = RestAssured.given();
    JSONObject requestparams = new JSONObject();
   // requestparams.replace("username", "cchauhan281188");
    requestparams.put("username", "chandan");
    httppatchrequest.header("Content-Type", "application/json");
    httppatchrequest.body(requestparams.toJSONString());
    
    Response patchresponse = httppatchrequest.request(Method.PATCH, "/users/1");
    String response = patchresponse.getBody().asString();
    System.out.println(response);
	}
}