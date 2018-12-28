package petstore.swagger.io.pet;

import domainentitites.PetMethods;
import org.junit.Test;
import generalmethods.CreateRequest;

public class TestPostAddANewPetToStore {
    PetMethods petMethods = new PetMethods();
    CreateRequest createRequest = new CreateRequest();

    @Test
    public void postRequestWithEmptyRequestBody() {
        String requestBody = createRequest.canCreateEmptyPetRequestBody();
        petMethods.canPostPetRequestByBodyAndAssertResponse("pet",createRequest.canCreateEmptyPetRequestBody(),"json",405);
    }
    @Test
    public void postRequestWithBasicRequestBody() {
        petMethods.canPostPetRequestByBodyAndAssertResponse("pet",createRequest.canCreateBasicPetRequestBody(),"json",200);
    }
    @Test
    public void postRequestWithFullRequestBody() {
        petMethods.canPostPetRequestByBodyAndAssertResponse("pet",createRequest.canCreateFullPetRequestBody(),"json",200);
        System.out.println("pet");
    }
}
