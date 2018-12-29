package generalmethods;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.junit.Assert.assertEquals;

public class AssertResponse {
    ParseJSON parseJSON = new ParseJSON();

    public void canAssertAResponseKey(String  requestBody , Response response, String keyToAssert) {

        String expectedValue = parseJSON.canReturnAKeyValuefromJSONStringBody(requestBody.toString(),keyToAssert,"Expected");

        String actualValue = parseJSON.canReturnAKeyValuefromJSONStringBody(response.getBody().asString(),keyToAssert,"Actual  ");
        assertEquals(expectedValue,actualValue);
    }

    public void canAssertResponseStatus(long  expectedStatus , long actualStatus) {
        System.out.println("Actual StatusCode   : " + actualStatus);
        System.out.println("Expected StatusCode : " + expectedStatus);
        assertEquals(expectedStatus, actualStatus);
    }

}
