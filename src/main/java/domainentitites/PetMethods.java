package domainentitites;

import io.restassured.response.Response;
import generalmethods.*;
import projectconfiguration.TestEnvironment;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PetMethods {

    TestEnvironment testEnv = new TestEnvironment();
    GetRequest getRequest = new GetRequest();
    DeleteRequest deleteRequest = new DeleteRequest();
    CreatePetRequest createPetRequest = new CreatePetRequest();
    PostRequest postRequest = new PostRequest();
    PutRequest putRequest = new PutRequest();
    AssertResponse assertResponse = new AssertResponse();
/*
NOTE : "Implementing below method with petID as String and not as Integer to be able to test " +
"both negative and positive tests")
*/
    public void canFindPetByIDAndAssertStatus(String  pet , String petID, long expectedStatus ) {
//
        //@Test
        //public void canFindPetByID() {
        //String  pet = "pet";
        //String petID = "1";
        Response response = getRequest.canGiveResponseUsingPath(pet,petID);
        assertResponse.canAssertResponseStatus(expectedStatus,response.getStatusCode());
    }
    public void canFindPetByStatusAndAssertStatus(String endPoint, String  status , List<String> arguments, long expectedStatus ) {
//
        //
        //@Test
        //public void canFindPetByIDAndAssertHeader() {
        //String  endPoint = "pet/findByStatus";
        //String  status = "status";
        //List<String> arguments = new ArrayList<String>();
        //arguments.add("available");
        //arguments.add("pending");
        //System.out.println("arguments " + values);
        //System.out.println(arguments.size());
        //System.out.println(arguments.get(0) );
        //System.out.println(arguments.get(1) );
        //long expectedStatus = 200;
        //
        Response response = getRequest.canGiveResponseUsingQuery(endPoint,status,arguments);
        assertResponse.canAssertResponseStatus(expectedStatus,response.getStatusCode());
    }
    public void canDeletePetByIDAndAssertStatus(String  pet , String petID, long expectedStatus ) {
//
        //@Test
        //public void canFindPetByID() {
        //String  pet = "pet";
        //String petID = "1";
        Response response = deleteRequest.canDeleteElementUsingPath(pet,petID);
        assertResponse.canAssertResponseStatus(expectedStatus,response.getStatusCode());
    }

    public void canPostPetRequestByBodyAndAssertResponse(String  pet , String requestBody, String contentType, long expectedStatus ) {
//
        //@Test
        //public void canPostPetRequestByBodyAndAssertStatus() {
        //String pet = "pet";
        //String requestBody = createPetRequest.canCreatePetRequestBody();
        //String contentType = "json";
        //long expectedStatus = 200;

        Response response = postRequest.canPostRequestUsingBody(pet, requestBody, "application/" + contentType);
        assertResponse.canAssertResponseStatus(expectedStatus,response.getStatusCode());
        // Assert that the ID from response is same as ID given in the request.
        assertResponse.canAssertAResponseKeyValue(requestBody,response,"id");
        assertResponse.canAssertAResponseKeyValue(requestBody,response,"name");
        assertResponse.canAssertAResponseKeyValue(requestBody,response,"status");
    }
    public void canPutPetRequestByBodyAndAssertResponse(String  pet , String requestBody, String contentType, long expectedStatus ) {
//
        //@Test
        //public void canPutPetRequestByBodyAndAssertResponse() {
        //String pet = "pet";
        //String requestBody = createPetRequest.canCreateCustomPetRequestBody();
        //String contentType = "json";
        //long expectedStatus = 200;

        Response response = putRequest.canPutRequestUsingBody(pet, requestBody, "application/" + contentType);
        assertResponse.canAssertResponseStatus(expectedStatus,response.getStatusCode());
        // Assert that the ID from response is same as ID given in the request.
        assertResponse.canAssertAResponseKeyValue(requestBody,response,"id");
        assertResponse.canAssertAResponseKeyValue(requestBody,response,"name");
        assertResponse.canAssertAResponseKeyValue(requestBody,response,"status");
    }
    public void canPostPetRequestByPathAndAssertResponse(String  pet , String petID, String nameValue,  String statusValue, String contentType, long expectedStatus ) {
//
        //@Test
        //public void canPutPetRequestByBodyAndAssertResponse() {
        //String pet = "pet";
        //String requestBody = createPetRequest.canCreateCustomPetRequestBody();
        //String contentType = "json";
        //long expectedStatus = 200;

        Response response = postRequest.canPostRequestUsingPathAndParameters(pet, petID, nameValue, statusValue,"application/" + contentType);
        assertResponse.canAssertResponseStatus(expectedStatus,response.getStatusCode());
    }
    public void canPostPetRequestByPathAndFileFormData(String  pet , String petID, String metadataValue,  String filePath, String contentType, long expectedStatus ) {
//
        //@Test
        //public void canPutPetRequestByBodyAndAssertResponse() {
        //String pet = "pet";
        //String requestBody = createPetRequest.canCreateCustomPetRequestBody();
        //String contentType = "json";
        //long expectedStatus = 200;

        Response response = postRequest.canPostRequestUsingPathAndFileParameter(pet, petID, metadataValue, filePath,"application/" + contentType);
        assertResponse.canAssertResponseStatus(expectedStatus,response.getStatusCode());
    }
}
