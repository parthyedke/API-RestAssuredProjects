package apiProjects;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_GETuserINFO {
	
	
	@Test
	public void GetuserINFO()
	{
		RestAssured.basePath="http://restapi.demoqa.com/customer";
		
		RequestSpecification requestfor= RestAssured.given();
		
		Response response= requestfor.request(Method.GET,"");
		
		String respBody=response.getBody().asString();
		System.out.println(respBody);
		
	}

}
