package restassured.practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {
	
	@Test
	public void postRequest() {
		
		RestAssured.baseURI = "https://dev124530.service-now.com/api/now/table/incident";

		RestAssured.authentication = RestAssured.basic("admin", "3tiK$+Ef0aBI");
		
		RequestSpecification request = RestAssured
				.given()
				.log()
				.all()
				.contentType(ContentType.JSON);
		
		Response response = request.post();
		System.out.println(response.prettyPrint());
	}

}
