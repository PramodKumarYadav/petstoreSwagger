package petstore.swagger.io.pet;

import domainentitites.PetMethods;
import generalmethods.AssertResponse;
import generalmethods.ParseJSON;
import io.restassured.path.json.JsonPath;
import org.junit.Test;
import generalmethods.CreateRequest;

public class TestPostAddANewPetToStore {
    PetMethods petMethods = new PetMethods();
    CreateRequest createRequest = new CreateRequest();
    ParseJSON parseJSON = new ParseJSON();

    @Test
    public void postRequestWithEmptyRequestBody() {
        String requestBody = createRequest.canCreateEmptyPetRequestBody();
        petMethods.canPostPetRequestByBodyAndAssertResponse("pet",requestBody,"json",405);

        // Get request ID
        String petID = parseJSON.canReturnAKeyValuefromJSONStringBody(requestBody.toString(),"id","Search using ");

        // Search to ensure that pet was deleted (so not found).
        petMethods.canFindPetByIDAndAssertStatus("pet",petID,200);
    }
    @Test
    public void postRequestWithBasicRequestBody() {
        String requestBody = createRequest.canCreateBasicPetRequestBody();
        petMethods.canPostPetRequestByBodyAndAssertResponse("pet",requestBody,"json",200);

        // Get request ID
        String petID = parseJSON.canReturnAKeyValuefromJSONStringBody(requestBody.toString(),"id","Search using ");

        // Search to ensure that pet was deleted (so not found).
        petMethods.canFindPetByIDAndAssertStatus("pet",petID,200);
    }
    @Test
    public void postRequestWithFullRequestBody() {
        String requestBody = createRequest.canCreateFullPetRequestBody();
        petMethods.canPostPetRequestByBodyAndAssertResponse("pet",requestBody,"json",200);

        // Get request ID
        String petID = parseJSON.canReturnAKeyValuefromJSONStringBody(requestBody.toString(),"id","Search using ");

        // Search to ensure that pet was deleted (so not found).
        petMethods.canFindPetByIDAndAssertStatus("pet",petID,200);
    }
}
