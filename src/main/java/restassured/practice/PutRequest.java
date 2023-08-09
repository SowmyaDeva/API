package restassured.practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PutRequest {
	
	@Test
	public void updateIncident() {
		
		RestAssured.baseURI = "https://dev124530.service-now.com/api/now/table/incident/19bde04847e471106f612f23846d4374";
		
		RestAssured.authentication = RestAssured.basic("admin", "3tiK$+Ef0aBI");

		Response response = RestAssured.given().contentType(ContentType.JSON).body("{\r\n"
				+ "    \"category\": \"hardware\"\r\n"
				+ "}").put();
		System.out.println(response.getStatusCode());
		
		response.prettyPrint();

	}

}
