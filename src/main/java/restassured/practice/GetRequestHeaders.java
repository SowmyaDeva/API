package restassured.practice;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequestHeaders {

	@Test
	public void sendGetRequest() {

		// End point
		RestAssured.baseURI = "https://dev124530.service-now.com/api/now/table/incident";

		Map<String, String> allQueryParam = new HashMap<String, String>();
		allQueryParam.put("category", "software");
		allQueryParam.put("sysparm_fields", "category,sys_id,number,priority,description");
		
		// Add Request
		RestAssured.authentication = RestAssured.basic("admin", "3tiK$+Ef0aBI");
		RequestSpecification request = RestAssured
				.given()
				.log()
				.all()
				.queryParams(allQueryParam)
				.accept(ContentType.JSON);

		// Send Request
		Response response = request.get();

		// Validate Response
		System.out.println(response.statusCode());
		response.prettyPrint();
	}

}
