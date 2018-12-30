package petstore.swagger.io.store;

import domainentitites.CreateOrderRequest;
import domainentitites.CreatePetRequest;
import domainentitites.PetMethods;
import domainentitites.StoreMethods;
import generalmethods.*;
import io.restassured.response.Response;
import org.junit.Test;
import projectconfiguration.TestEnvironment;

public class TestDeleteOrderByID {
    StoreMethods storeMethods = new StoreMethods();
    CreateOrderRequest createOrderRequest = new CreateOrderRequest();
    ParseJSON parseJSON = new ParseJSON();

    @Test
    public void tryDeleteingExistingOrderID() {

        // First create a order to ensure the order exists for deletion
        String requestBody = createOrderRequest.canCreateBasicOrderRequestBody();
        storeMethods.canPostOrderRequestByBodyAndAssertResponse("store/order",requestBody,"json",200);

        // Get request ID
        String orderID = parseJSON.canReturnAKeyValuefromJSONStringBody(requestBody.toString(),"id","Search using ");

        // Delete the pet using petID (so response code 200)
        storeMethods.canDeleteOrderByIDAndAssertStatus("store/order", orderID, 200);

        // Search to ensure that order was deleted (so not found).
        storeMethods.canGetOrderByIDAndAssertStatus("store/order",orderID,404);
    }
    @Test
    public void tryDeleteingNonExistingOrderID() {
        storeMethods.canDeleteOrderByIDAndAssertStatus("store/order","112112323",404);
    }
    @Test
    public void tryDeleteingInvalidOrderID() {
        storeMethods.canDeleteOrderByIDAndAssertStatus("store/order","abcdf",400);
    }

}