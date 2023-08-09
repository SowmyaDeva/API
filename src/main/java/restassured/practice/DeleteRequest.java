package restassured.practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteRequest {
	
	@Test
	public void updateIncident() {
		
		RestAssured.baseURI = "https://dev124530.service-now.com/api/now/table/incident/6061380c47e471106f612f23846d4391";
		
		RestAssured.authentication = RestAssured.basic("admin", "3tiK$+Ef0aBI");

		Response response = RestAssured.given().delete();
		
		System.out.println(response.getStatusCode());
		
}

}
