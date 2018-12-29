package generalmethods;

import domainentitites.CreatePetRequest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import projectconfiguration.TestEnvironment;

public class PutRequest {
    TestEnvironment testEnv = new TestEnvironment();
    CreatePetRequest createPetRequest = new CreatePetRequest();

    public Response canPutRequestUsingBody(String  pathParam , String requestBody, String contentType ) {
        System.out.println("Entered canPutRequestUsingBody method");
//
        //@Test
        //public void canPutRequestUsingBody() {
        //String  pathParam = "pet";
        //String requestBody = createPetRequest.canCreateCustomPetRequestBody();
        //System.out.println(requestBody);
        //String contentType = "application/json";
        //Step 01: Parse response from page

        String swaggerURL  =  testEnv.getBaseURL();
        String apiURL = swaggerURL + "/" + pathParam;
        System.out.println("apiURL :" + apiURL);

        // use RestAssured to make an HTML Call
        Response response = RestAssured.
                given().request().
                contentType(contentType).
                body(requestBody).
                put(apiURL).thenReturn();
        System.out.println(response.prettyPeek());
        return response;
    }
}
