package restassured.practice;

import java.io.File;
import java.nio.channels.AcceptPendingException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestWithReqBodyAsFile {
	
	@Test
	public void postRequest() {
		
		RestAssured.baseURI = "https://dev124530.service-now.com/api/now/table/incident";

		RestAssured.authentication = RestAssured.basic("admin", "3tiK$+Ef0aBI");
		
		File inputFile = new File("./data/CreateIncident.json");
		
		RequestSpecification request = RestAssured
				.given()
				.log()
				.all()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(inputFile);
				
		
		Response response = request.post();
		System.out.println(response.prettyPrint());
		
	}

}
