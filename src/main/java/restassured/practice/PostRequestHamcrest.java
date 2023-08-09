package restassured.practice;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import base.*;

public class PostRequestHamcrest extends BaseClass{
	
	@Test
	public void postRequest() {
				
		ValidatableResponse response = RestAssured
				.given()
				.log()
				.all()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body("{\r\n"
						+ "    \"description\": \"This is my first incident\",\r\n"
						+ "    \"short_description\": \"laptop display not working\"\r\n"
						+ "}")
				.post("incident").then().body(containsString("sys_id"));
		
		
	}

}
