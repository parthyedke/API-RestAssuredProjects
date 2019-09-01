package apiProjects;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET {
	
	@Test
	public void get()
	{
		//Specify the base URI
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		//Request the object
		RequestSpecification requestfor=RestAssured.given();
		
		//Response object
		Response response=requestfor.request(Method.GET,"/delhi");
		
		//Print respose in console wondow
		
		String respBody=response.getBody().asString();
		System.out.println(respBody);
		
		//status code print
		int statuscode=response.getStatusCode();
		System.out.println(statuscode);
		Assert.assertEquals(200, statuscode);
		
		// Status line print
		
		String statusline=response.getStatusLine();
		System.out.println(statusline);
	
		  
	}

}
