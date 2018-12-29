package domainentitites;

import generalmethods.*;
import io.restassured.response.Response;
import projectconfiguration.TestEnvironment;

public class StoreMethods {
    TestEnvironment testEnv = new TestEnvironment();
    GetRequest getRequest = new GetRequest();
    DeleteRequest deleteRequest = new DeleteRequest();
    CreatePetRequest createPetRequest = new CreatePetRequest();
    PostRequest postRequest = new PostRequest();
    PutRequest putRequest = new PutRequest();
    AssertResponse assertResponse = new AssertResponse();
    public void canPostOrderRequestByBodyAndAssertResponse(String  pathParam , String requestBody, String contentType, long expectedStatus ) {
//
        //@Test
        //public void canPostPetRequestByBodyAndAssertStatus() {
        //String pathParam = "store/order";
        //String requestBody = createPetRequest.canCreatePetRequestBody();
        //String contentType = "json";
        //long expectedStatus = 200;

        Response response = postRequest.canPostRequestUsingBody(pathParam, requestBody, "application/" + contentType);
        assertResponse.canAssertResponseStatus(expectedStatus,response.getStatusCode());
        // Assert that the ID from response is same as ID given in the request.
//        assertResponse.canAssertAResponseKeyValue(requestBody,response,"id");
//        assertResponse.canAssertAResponseKeyValue(requestBody,response,"name");
//        assertResponse.canAssertAResponseKeyValue(requestBody,response,"status");
    }
    public void canGetInventoryAndAssertResponse(String  pathParam , long expectedStatus ) {
//
        //@Test
        //public void canFindPetByID() {
        //String  pet = "pet";
        //String petID = "1";
        Response response = getRequest.canGiveResponseWithNoParameters(pathParam);
        assertResponse.canAssertResponseStatus(expectedStatus,response.getStatusCode());
    }
}
