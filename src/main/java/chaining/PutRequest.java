package chaining;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PutRequest extends BaseClass {
	
	@Test(dependsOnMethods = "chaining.PostRequestWithReqBody.postRequest")
	public void updateIncident() {
		
		Response response = RestAssured.given().contentType(ContentType.JSON).body("{\r\n"
				+ "    \"category\": \"hardware\"\r\n"
				+ "}").put("incident/"+ sysid);
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		response.prettyPrint();

	}

}
