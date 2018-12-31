package petstore.swagger.io.pet;

import TestData.CreatePetRequest;
import domainentitites.PetMethods;
import generalmethods.ParseJSON;
import org.junit.Test;

public class TestPostUploadAnImpage {
    PetMethods petMethods = new PetMethods();
    CreatePetRequest createPetRequest = new CreatePetRequest();
    ParseJSON parseJSON = new ParseJSON();
    @Test
    // TODO: 12/29/2018
    public void postRequestUpdatenameAndStatus_pending() {
        String requestBodyRandomData = createPetRequest.canCreateFullPetRequestBody();
        petMethods.canPostPetRequestByBodyAndAssertResponse("pet",requestBodyRandomData,"json",200);

        // Get request ID
        String petID = parseJSON.canReturnAKeyValuefromJSONStringBody(requestBodyRandomData.toString(),"id","Search using ");

        petMethods.canPostPetRequestByPathAndFileFormData("pet", petID, "dummy","dummy","json",200);
    }
}
