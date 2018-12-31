package domainentitites;

import generalmethods.*;
import io.restassured.response.Response;
import TestData.CreatePetRequest;
import projectconfiguration.TestEnvironment;

public class StoreMethods {
    TestEnvironment testEnv = new TestEnvironment();
    GetRequest getRequest = new GetRequest();
    DeleteRequest deleteRequest = new DeleteRequest();
    CreatePetRequest createPetRequest = new CreatePetRequest();
    PostRequest postRequest = new PostRequest();
    PutRequest putRequest = new PutRequest();
    AssertResponse assertResponse = new AssertResponse();

    public Response canGetStoreInventory(String  endPointStoreInventory) {
        Response response = getRequest.canGiveResponseWithNoParameters(endPointStoreInventory);
        return response;
    }
    public void canGetInventoryAndAssertResponse(String  endPoint , long expectedStatus ) {
//
        //@Test
        //public void canFindPetByID() {
        //String  pet = "pet";
        //String petID = "1";
        Response response = getRequest.canGiveResponseWithNoParameters(endPoint);
        assertResponse.canAssertResponseStatus(expectedStatus,response.getStatusCode());
    }
    public void canPostOrderRequestByBodyAndAssertResponse(String  endPoint , String requestBody, String contentType, long expectedStatus ) {
//
        //@Test
        //public void canPostPetRequestByBodyAndAssertStatus() {
        //String pathParam = "store/order";
        //String requestBody = createPetRequest.canCreatePetRequestBody();
        //String contentType = "json";
        //long expectedStatus = 200;

        Response response = postRequest.canPostRequestUsingBody(endPoint, requestBody, "application/" + contentType);
        assertResponse.canAssertResponseStatus(expectedStatus,response.getStatusCode());
        // Assert that the ID from response is same as ID given in the request.
//        assertResponse.canAssertAResponseKeyValue(requestBody,response,"id");
//        assertResponse.canAssertAResponseKeyValue(requestBody,response,"name");
//        assertResponse.canAssertAResponseKeyValue(requestBody,response,"status");
    }
    public void canDeleteOrderByIDAndAssertStatus(String  endPoint , String orderID, long expectedStatus ) {
//
        //@Test
        //public void canFindPetByID() {
        //String  endPoint = "store/order";
        //String orderID = "10";

        Response response = deleteRequest.canDeleteElementUsingPath(endPoint,orderID);
        assertResponse.canAssertResponseStatus(expectedStatus,response.getStatusCode());
    }
    public void canGetOrderByIDAndAssertStatus(String  endPoint , String orderID, long expectedStatus ) {
//
        //@Test
        //public void canFindPetByID() {
        //String  endPoint= "store/order";
        //String orderID = "9";
        Response response = getRequest.canGiveResponseUsingPath(endPoint,orderID);
        assertResponse.canAssertResponseStatus(expectedStatus,response.getStatusCode());
    }
}
