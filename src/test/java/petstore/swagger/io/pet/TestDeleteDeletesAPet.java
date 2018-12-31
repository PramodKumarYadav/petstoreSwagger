package petstore.swagger.io.pet;

import TestData.CreatePetRequest;
import domainentitites.PetMethods;
import generalmethods.ParseJSON;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestDeleteDeletesAPet {
    PetMethods petMethods = new PetMethods();
    CreatePetRequest createPetRequest = new CreatePetRequest();
    ParseJSON parseJSON = new ParseJSON();

    @Test
    public void deleteExistingPetID() {

        // First create a request to ensure the ID exists for deletion
        String requestBody = createPetRequest.canCreateBasicPetRequestBody();
        petMethods.canPostPetRequestByBodyAndAssertResponse("pet",requestBody,"json",200);

        // Get request ID
        String petID = parseJSON.canReturnAKeyValuefromJSONStringBody(requestBody.toString(),"id","Search using ");

        // Delete the pet using petID (so response code 200)
        petMethods.canDeletePetByIDAndAssertStatus("pet",petID,200);

        // Search to ensure that pet was deleted (so not found).
        petMethods.canFindPetByIDAndAssertStatus("pet",petID,404);

    }
    @Test
    public void tryDeleteingNonExistingPetID() {
        petMethods.canDeletePetByIDAndAssertStatus("pet","6281930314171690275",404);
    }
    @Test
    public void tryDeleteingInvalidPetID() {

        petMethods.canDeletePetByIDAndAssertStatus("pet","abcdefgh",400);
    }
}
