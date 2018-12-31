package domainentitites;

import generalmethods.*;
import io.restassured.response.Response;
import TestData.CreatePetRequest;
import projectconfiguration.TestEnvironment;

public class UserMethods {
    TestEnvironment testEnv = new TestEnvironment();
    GetRequest getRequest = new GetRequest();
    DeleteRequest deleteRequest = new DeleteRequest();
    CreatePetRequest createPetRequest = new CreatePetRequest();
    PostRequest postRequest = new PostRequest();
    PutRequest putRequest = new PutRequest();
    AssertResponse assertResponse = new AssertResponse();
    public void canGetUserByUserNameAndAssertStatus(String  endPointUser , String username, long expectedStatus ) {
//
        //@Test
        //public void canGetUserByUserNameAndAssertStatus() {
        //String  endPoint= "user;
        //String username = "user1";
        Response response = getRequest.canGiveResponseUsingPath(endPointUser,username);
        assertResponse.canAssertResponseStatus(expectedStatus,response.getStatusCode());
    }
    public void canLogoutUserAndAssertResponse(String  endPointUserLogout , long expectedStatus ) {
//
        //@Test
        //public void canLogoutUserAndAssertResponse() {
        //String  endPoint = "user/logout";

        Response response = getRequest.canGiveResponseWithNoParameters(endPointUserLogout);
        assertResponse.canAssertResponseStatus(expectedStatus,response.getStatusCode());
    }
    public void canLogInUserAndAssertResponse(String endPointUserLogin, String  queryUsernamePassword , long expectedStatus ) {
//
        //@Test
        //public void canLogInUserAndAssertResponse() {
        //String  endPoint = "user/login";
        //Query = ?username=user1&password=pass%40123

        Response response = getRequest.canGiveResponseUsingFullQueryAsInput(endPointUserLogin,queryUsernamePassword);
        assertResponse.canAssertResponseStatus(expectedStatus,response.getStatusCode());
    }
    public void canCreateUserByBodyAndAssertResponse(String  endPointUser , String requestBodyUser, String contentType, long expectedStatus ) {
//
        //@Test
        //public void canPostPetRequestByBodyAndAssertStatus() {
        //String pathParam = "store/order";
        //String requestBody = createPetRequest.canCreatePetRequestBody();
        //String contentType = "json";
        //long expectedStatus = 200;

        Response response = postRequest.canPostRequestUsingBody(endPointUser, requestBodyUser, "application/" + contentType);
        assertResponse.canAssertResponseStatus(expectedStatus,response.getStatusCode());
        // Assert that the ID from response is same as ID given in the request.
//        assertResponse.canAssertAResponseKeyValue(requestBody,response,"id");
//        assertResponse.canAssertAResponseKeyValue(requestBody,response,"name");
//        assertResponse.canAssertAResponseKeyValue(requestBody,response,"status");
    }
    public void canUpdateUserByBodyAndPathAndAssertResponse(String  endPointUser , String username, String requestBody, String contentType, long expectedStatus ) {
        Response response = putRequest.canPutRequestUsingBody(endPointUser, requestBody, "application/" + contentType);

        assertResponse.canAssertResponseStatus(expectedStatus,response.getStatusCode());
    }
    public void canDeleteUserByUserNameAndAssertStatus(String  endPointUser , String username, long expectedStatus ) {
        Response response = deleteRequest.canDeleteElementUsingPath(endPointUser,username);
        assertResponse.canAssertResponseStatus(expectedStatus,response.getStatusCode());
    }

}
