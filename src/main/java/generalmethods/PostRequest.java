package generalmethods;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import projectconfiguration.TestEnvironment;

public class PostRequest {
    TestEnvironment testEnv = new TestEnvironment();
    CreateRequest createRequest = new CreateRequest();

    public Response canPostRequestUsingPathAndBody(String  pathParam , String requestBody, String contentType ) {
//
        //@Test
        //public void canPostRequestUsingPathAndBody() {
        //String  pathParam = "pet";
        //String requestBody = createRequest.canCreatePetRequestBody();
        //System.out.println(requestBody);
        //String contentType = "application/json";
        //Step 01: Parse response from page

        String swaggerURL  =  testEnv.getBaseURL();
        String apiURL = swaggerURL + "/" + pathParam;
        System.out.println("apiURL :" + apiURL);

        // use RestAssured to make an HTML Call
        Response response = RestAssured.
                given().request().
//
                //header("Access-Control-Allow-Origin","*").
                //header("Access-Control-Allow-Methods","GET, POST, DELETE, PUT").
                //header("Access-Control-Allow-Headers","Content-Type, api_key, Authorization").
                //header("Content-Type","application/json").
                contentType(contentType).
                body(requestBody).
                post(apiURL).thenReturn();
//        System.out.println(response.prettyPeek());
        return response;
    }
}
