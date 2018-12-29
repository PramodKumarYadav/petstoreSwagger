package petstore.swagger.io.pet;

import domainentitites.PetMethods;
import domainentitites.CreatePetRequest;
import generalmethods.ParseJSON;
import org.junit.Test;

public class TestPutUpdateAnExistingPet {
    PetMethods petMethods = new PetMethods();
    CreatePetRequest createPetRequest = new CreatePetRequest();
    ParseJSON parseJSON = new ParseJSON();

    @Test
    public void putRequestUpdateRandomDataEmptyNameAndStatus() {
        String requestBodyRandomData = createPetRequest.canCreateFullPetRequestBody();
        petMethods.canPostPetRequestByBodyAndAssertResponse("pet",requestBodyRandomData,"json",200);

        // Get request ID
        String petID = parseJSON.canReturnAKeyValuefromJSONStringBody(requestBodyRandomData.toString(),"id","Search using ");

        String requestBody = createPetRequest.canCreateCustomPetRequestBody(petID,"","");
        petMethods.canPutPetRequestByBodyAndAssertResponse("pet",requestBody,"json",200);
    }
    @Test
    public void putRequestUpdateRandomDataStatusAvailable() {
        String requestBodyRandomData = createPetRequest.canCreateFullPetRequestBody();
        petMethods.canPostPetRequestByBodyAndAssertResponse("pet",requestBodyRandomData,"json",200);

        // Get request ID
        String petID = parseJSON.canReturnAKeyValuefromJSONStringBody(requestBodyRandomData.toString(),"id","Search using ");

        String requestBody = createPetRequest.canCreateCustomPetRequestBody(petID,"PUT_ChangeToPramod","available");
        petMethods.canPutPetRequestByBodyAndAssertResponse("pet",requestBody,"json",200);
    }
    @Test
    public void putRequestUpdateRandomDataPending() {
        String requestBodyRandomData = createPetRequest.canCreateFullPetRequestBody();
        petMethods.canPostPetRequestByBodyAndAssertResponse("pet",requestBodyRandomData,"json",200);

        // Get request ID
        String petID = parseJSON.canReturnAKeyValuefromJSONStringBody(requestBodyRandomData.toString(),"id","Search using ");

        String requestBody = createPetRequest.canCreateCustomPetRequestBody(petID,"PUT_ChangeToPramod","pending");
        petMethods.canPutPetRequestByBodyAndAssertResponse("pet",requestBody,"json",200);
    }
    @Test
    public void putRequestUpdateRandomDataSold() {
        String requestBodyRandomData = createPetRequest.canCreateFullPetRequestBody();
        petMethods.canPostPetRequestByBodyAndAssertResponse("pet",requestBodyRandomData,"json",200);

        // Get request ID
        String petID = parseJSON.canReturnAKeyValuefromJSONStringBody(requestBodyRandomData.toString(),"id","Search using ");

        String requestBody = createPetRequest.canCreateCustomPetRequestBody(petID,"PUT_ChangeToPramod","sold");
        petMethods.canPutPetRequestByBodyAndAssertResponse("pet",requestBody,"json",200);
    }

}
