package generalmethods;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.junit.Assert.assertEquals;

public class AssertResponse {
    ParseJSON parseJSON = new ParseJSON();


    public void canAssertResponseStatus(long  expectedStatus , long actualStatus) {
        System.out.println("Entered canAssertResponseStatus method");
        System.out.println("Actual StatusCode   : " + actualStatus);
        System.out.println("Expected StatusCode : " + expectedStatus);
        assertEquals(expectedStatus, actualStatus);
    }
    public void canAssertAResponseKeyValue(String  requestBody , Response response, String key) {
        System.out.println("Entered canAssertAResponseKey method");
        String expectedValue = parseJSON.canReturnAKeyValuefromJSONStringBody(requestBody.toString(),key,"Expected");

        String actualValue = parseJSON.canReturnAKeyValuefromJSONStringBody(response.getBody().asString(),key,"Actual  ");
        assertEquals(expectedValue,actualValue);
    }
}
