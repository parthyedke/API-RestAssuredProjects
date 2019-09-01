package apiProjects;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_PostMethod {
	
	
	@Test
	public void post()
	{
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		
		RequestSpecification requestfor= RestAssured.given();
		
		JSONObject requestpara= new JSONObject();
		
		requestpara.put("FirstName", "sai");
		requestpara.put("LastName", "sai1");
		requestpara.put("UserName", "sai11");
		requestpara.put("Password", "sai111");
		requestpara.put("Email", "sai@gmail.com");
		
		requestfor.header("Content-Type","application/json");
		
		requestfor.body(requestpara.toJSONString());
		
		Response response=requestfor.request(Method.POST,"/register");
		
		String respBody=response.getBody().asString();
		System.out.println(respBody);
		
		int statusCode=response.getStatusCode();
		System.out.println(statusCode);
		
		String successCode= response.jsonPath().get("SuccessCode");
		System.out.println(successCode);
		
	}
	
	
}
