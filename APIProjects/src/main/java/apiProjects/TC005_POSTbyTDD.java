package apiProjects;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_POSTbyTDD {

	@Test(dataProvider ="ApiData")
	
	public void POSTbyTDD(String ename, String esalary,String eage )
	{
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		
		RequestSpecification requestfor=RestAssured.given();
		
		JSONObject reqpara=new JSONObject();
		reqpara.put("name", ename);
		reqpara.put("salary",esalary);
		reqpara.put("age",eage );
		
		requestfor.header("Content-Type","application/json");
		requestfor.body(reqpara.toJSONString());
		
		Response response=requestfor.request(Method.POST,"/create");
		
		String reqsBody= response.getBody().asString();
		System.out.println(reqsBody);
		
		Assert.assertEquals(reqsBody.contains(ename), true);
		Assert.assertEquals(reqsBody.contains(esalary), true);
		Assert.assertEquals(reqsBody.contains(eage), true);
		
		
		int resCode=response.getStatusCode();
		System.out.println(resCode);
		
	
		
	}
	
	@DataProvider(name="ApiData")
	public Object[][] methoddata()
	{
		return new Object[][]
				{{"sai111","620000","27"},{"sai1111","720000","28"},
				{"sai2222","830000","29"}
				
				};
	}
	
}
