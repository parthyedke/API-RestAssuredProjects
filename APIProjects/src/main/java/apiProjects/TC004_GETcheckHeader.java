package apiProjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_GETcheckHeader {
	
	@Test
	public void GetcheckHeader()
	{
		RestAssured.baseURI="https://maps.googleapis.com";
		
		RequestSpecification requestfor=RestAssured.given();
		
		Response response=requestfor.request(Method.GET,"/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&"
				+ "type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
		
//		String respBody=response.getBody().asString();
//		System.out.println(respBody);
		
		int statusCode=response.getStatusCode();
		System.out.println(statusCode);
		
		String contentType=response.header("Content-Type");// capture details of Content-Type header
		System.out.println("Content Type is:"+contentType);
		Assert.assertEquals(contentType, "application/xml; charset=UTF-8");
		
		String contentType1=response.header("Server");
		System.out.println(contentType1);
		Assert.assertEquals(contentType1, "scaffolding on HTTPServer2");
		
		
		System.out.println("------------------------------------------------------------------------");
		
		//System.out.println(response.headers());
		
		Headers allheaders= response.headers();
		for(Header header:allheaders)
		{
			System.out.println(header.getName()+"\t"+header.getValue());
		}
		
		
	}

}
