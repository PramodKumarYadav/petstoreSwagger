package petstore.swagger.io.pet;

import domainentitites.CreatePetRequest;
import domainentitites.PetMethods;
import generalmethods.ParseJSON;
import org.junit.Test;

public class TestPostAddANewPetToStore {
    PetMethods petMethods = new PetMethods();
    CreatePetRequest createPetRequest = new CreatePetRequest();
    ParseJSON parseJSON = new ParseJSON();

    @Test
    public void postRequestWithEmptyRequestBody() {
        String requestBody = createPetRequest.canCreateEmptyPetRequestBody();
        petMethods.canPostPetRequestByBodyAndAssertResponse("pet",requestBody,"json",405);
    }
    @Test
    public void postRequestWithBadRequestBody() {
        String requestBody = createPetRequest.canCreateBadPetRequestBody();
        petMethods.canPostPetRequestByBodyAndAssertResponse("pet",requestBody,"json",400);
    }
    @Test
    public void postRequestWithBasicRequestBody() {
        String requestBody = createPetRequest.canCreateBasicPetRequestBody();
        petMethods.canPostPetRequestByBodyAndAssertResponse("pet",requestBody,"json",200);
    }
    @Test
    public void postRequestWithFullRequestBody() {
        String requestBody = createPetRequest.canCreateFullPetRequestBody();
        petMethods.canPostPetRequestByBodyAndAssertResponse("pet",requestBody,"json",200);
    }


}
