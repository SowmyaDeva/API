package chaining;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import base.*;

public class PostRequestWithReqBody extends BaseClass{
	
	@Test
	public void postRequest() {
				
		Response response = RestAssured
				.given()
				.log()
				.all()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body("{\r\n"
						+ "    \"description\": \"This is my first incident\",\r\n"
						+ "    \"short_description\": \"laptop display not working\"\r\n"
						+ "}")
				.post("incident");
		JsonPath path = response.jsonPath();
		sysid = path.get("result.sys_id");
		System.out.println(sysid);
		System.out.println(response.prettyPrint());
		Assert.assertEquals(response.statusCode(), 201);
		
		String asString = response.asString();
		Assert.assertEquals(asString, "sys_id");

		
	}

}
