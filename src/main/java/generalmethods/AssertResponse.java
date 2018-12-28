package generalmethods;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.junit.Assert.assertEquals;

public class AssertResponse {
    public void canAssertAResponseKey(String  requestBody , Response response, String keyToAssert) {

        String jsonStringrequestBody = requestBody.toString();
        JsonPath jsonPathrequestBody = new JsonPath(jsonStringrequestBody);
        System.out.println("Expected Pet " + keyToAssert +" :" + jsonPathrequestBody.getString(keyToAssert));

        String jsonStringresponseBody = response.getBody().asString();
        JsonPath jsonPathresponseBody = new JsonPath(jsonStringresponseBody);
        System.out.println("Actual Pet " + keyToAssert +"   :" + jsonPathresponseBody.get(keyToAssert));

        assertEquals(jsonPathrequestBody.getString(keyToAssert),jsonPathresponseBody.getString(keyToAssert));
    }
}
