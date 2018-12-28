package domainentitites;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import generalmethods.*;
import org.junit.Test;
import projectconfiguration.TestEnvironment;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PetMethods {

    TestEnvironment testEnv = new TestEnvironment();
    GetResponse getResponse = new GetResponse();
    DeleteElement deleteElement = new DeleteElement();
    CreateRequest createRequest = new CreateRequest();
    PostRequest postRequest = new PostRequest();
    AssertResponse assertResponse = new AssertResponse();

   // NOTE : "Implementing below method with petID as String and not as Integer to be able to test " +
   //          "both negative and positive tests")
    public void canFindPetByIDAndAssertStatus(String  pet , String petID, long expectedStatus ) {
//    @Test
//    public void canFindPetByID() {
//        String  pet = "pet";
//        String petID = "1";
        Response response = getResponse.canGiveResponseUsingPath(pet,petID);
        System.out.println("Actual StatusCode   : " + response.getStatusCode());
        System.out.println("Expected StatusCode : " + expectedStatus);
        assertEquals(expectedStatus, response.getStatusCode());
    }
    public void canFindPetByStatusAndAssertStatus(String endPoint, String  status , List<String> arguments, long expectedStatus ) {
//    @Test
//    public void canFindPetByIDAndAssertHeader() {
//        String  endPoint = "pet/findByStatus";
//        String  status = "status";
//        List<String> arguments = new ArrayList<String>();
//        arguments.add("available");
//        arguments.add("pending");
//        System.out.println("arguments " + values);
//        System.out.println(arguments.size());
//        System.out.println(arguments.get(0) );
//        System.out.println(arguments.get(1) );
//        long expectedStatus = 200;
        Response response = getResponse.canGiveResponseUsingQuery(endPoint,status,arguments);
        System.out.println("Actual StatusCode   : " + response.getStatusCode());
        System.out.println("Expected StatusCode : " + expectedStatus);
        assertEquals(expectedStatus, response.getStatusCode());
    }
    public void canDeletePetByIDAndAssertStatus(String  pet , String petID, long expectedStatus ) {
//    @Test
//    public void canFindPetByID() {
//        String  pet = "pet";
//        String petID = "1";
        Response response = deleteElement.canDeleteElementUsingPath(pet,petID);
        System.out.println("Actual StatusCode   : " + response.getStatusCode());
        System.out.println("Expected StatusCode : " + expectedStatus);
        assertEquals(expectedStatus, response.getStatusCode());
    }

    public void canPostPetRequestByBodyAndAssertResponse(String  pet , String requestBody, String contentType, long expectedStatus ) {
//    @Test
//    public void canPostPetRequestByBodyAndAssertStatus() {
//        String pet = "pet";
//        String requestBody = createRequest.canCreatePetRequestBody();
//        String contentType = "json";
//        long expectedStatus = 200;

        Response response = postRequest.canPostRequestUsingPathAndBody(pet, requestBody, "application/" + contentType);
        System.out.println("Actual StatusCode   : " + response.getStatusCode());
        System.out.println("Expected StatusCode : " + expectedStatus);
        assertEquals(expectedStatus, response.getStatusCode());

        // Assert that the ID from response is same as ID given in the request.
        assertResponse.canAssertAResponseKey(requestBody,response,"id");
    }

}
