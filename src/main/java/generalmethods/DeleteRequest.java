package generalmethods;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import projectconfiguration.TestEnvironment;

public class DeleteRequest {

    TestEnvironment testEnv = new TestEnvironment();

    public Response canDeleteElementUsingPath(String  endpoint, String value) {
//
        //@Test
        //public void canDeleteElementUsingPath() {
        //String  pathParam = "pet";
        //String value = "6281930314171690275";
        //Step 01: Parse response from page

        String swaggerURL  =  testEnv.getBaseURL();
        String apiURL = swaggerURL + "/" + endpoint + "/" + value;
        System.out.println("apiURL :" + apiURL);

        // use RestAssured to make an HTML Call
        Response response = RestAssured.given().request().
                delete(apiURL).thenReturn();
        System.out.println(response.prettyPeek());
        return response;
    }
    public Response canDeleteElementUsingPath(String apiKey, String  pathParam, String value) {
//
        //@Test
        //public void canDeleteElementUsingPath() {
        //String  apiKey = "special-key";
        //String  pathParam = "pet";
        //String value = "6281930314171690275";
        //Step 01: Parse response from page

        String swaggerURL  =  testEnv.getBaseURL();
        String apiURL = swaggerURL + "/" + pathParam + "/" + value;
        System.out.println("apiURL :" + apiURL);

        // use RestAssured to make an HTML Call
        Response response = RestAssured.given().request().
                header("auth_token","special-key").
                delete(apiURL).thenReturn();
        System.out.println(response.prettyPeek());
        return response;
    }
}


