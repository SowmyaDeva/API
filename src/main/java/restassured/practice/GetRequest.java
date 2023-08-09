package restassured.practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetRequest {
	
	@Test
	public void sendGetRequest() {
		
		//End point
		RestAssured.baseURI = "https://dev124530.service-now.com/api/now/table/incident";
		
		//Add Request
		RestAssured.authentication = RestAssured.basic("admin", "3tiK$+Ef0aBI");
		
		//Send Request
		Response response = RestAssured.get();
		
		//Validate Response
		System.out.println(response.statusCode());
		response.prettyPrint();
	}

}
