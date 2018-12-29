package petstore.swagger.io.pet;

import domainentitites.CreatePetRequest;
import domainentitites.PetMethods;
import generalmethods.ParseJSON;
import org.junit.Test;

public class TestPostUpdatePetNameAndStatus {
    PetMethods petMethods = new PetMethods();
    CreatePetRequest createPetRequest = new CreatePetRequest();
    ParseJSON parseJSON = new ParseJSON();
    @Test
    public void postRequestUpdatenameAndStatus_pending() {
        String requestBodyRandomData = createPetRequest.canCreateFullPetRequestBody();
        petMethods.canPostPetRequestByBodyAndAssertResponse("pet",requestBodyRandomData,"json",200);

        // Get request ID
        String petID = parseJSON.canReturnAKeyValuefromJSONStringBody(requestBodyRandomData.toString(),"id","Search using ");

        petMethods.canPostPetRequestByPathAndAssertResponse("pet", petID, "POST_ChangeToPramod","pending","json",200);
    }
    @Test
    public void postRequestUpdatenameAndStatus_sold() {
        String requestBodyRandomData = createPetRequest.canCreateFullPetRequestBody();
        petMethods.canPostPetRequestByBodyAndAssertResponse("pet",requestBodyRandomData,"json",200);

        // Get request ID
        String petID = parseJSON.canReturnAKeyValuefromJSONStringBody(requestBodyRandomData.toString(),"id","Search using ");

        petMethods.canPostPetRequestByPathAndAssertResponse("pet", petID, "POST_ChangeToKumar","sold","json",200);
    }
    @Test
    public void postRequestUpdatenameAndStatus_available() {
        String requestBodyRandomData = createPetRequest.canCreateFullPetRequestBody();
        petMethods.canPostPetRequestByBodyAndAssertResponse("pet",requestBodyRandomData,"json",200);

        // Get request ID
        String petID = parseJSON.canReturnAKeyValuefromJSONStringBody(requestBodyRandomData.toString(),"id","Search using ");

        petMethods.canPostPetRequestByPathAndAssertResponse("pet", petID, "POST_ChangeToYadav","available","json",200);
    }
    @Test
    public void postRequestUpdatenameAndStatus_Empty() {
        String requestBodyRandomData = createPetRequest.canCreateFullPetRequestBody();
        petMethods.canPostPetRequestByBodyAndAssertResponse("pet",requestBodyRandomData,"json",200);

        // Get request ID
        String petID = parseJSON.canReturnAKeyValuefromJSONStringBody(requestBodyRandomData.toString(),"id","Search using ");

        petMethods.canPostPetRequestByPathAndAssertResponse("pet", petID, "","","json",200);
    }
}
