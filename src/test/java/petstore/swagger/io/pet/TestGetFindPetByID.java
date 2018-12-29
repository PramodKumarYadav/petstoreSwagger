package petstore.swagger.io.pet;

import domainentitites.CreatePetRequest;
import domainentitites.PetMethods;
import io.restassured.path.json.JsonPath;
import org.junit.Test;

public class TestGetFindPetByID {
    PetMethods petMethods = new PetMethods();
    CreatePetRequest createPetRequest = new CreatePetRequest();

    @Test
    public void searchWithExistingPetID() {

        // First create a request to ensure the ID exists for search
        String requestBody = createPetRequest.canCreateBasicPetRequestBody();
        petMethods.canPostPetRequestByBodyAndAssertResponse("pet",requestBody,"json",200);

        // Get request ID
        JsonPath jsonPathrequestBody = new JsonPath(requestBody);
        String petID = jsonPathrequestBody.getString("id");
        System.out.println("petID : " + petID);

        // Assert that id is found (response code 200)
        petMethods.canFindPetByIDAndAssertStatus("pet",petID,200);
    }
    @Test
    public void searchWithNonExistingPetID() {

        petMethods.canFindPetByIDAndAssertStatus("pet","123211",404);
    }
    @Test
    public void searchWithInvalidPetID() {
        petMethods.canFindPetByIDAndAssertStatus("pet","abd#$%",400);
    }
    @Test
    public void searchWithEmptyPetID() {
        petMethods.canFindPetByIDAndAssertStatus("pet","",405);
    }
}
