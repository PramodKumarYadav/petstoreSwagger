package petstore.swagger.io.store;

import TestData.CreateOrderRequest;
import domainentitites.StoreMethods;
import generalmethods.AssertResponse;
import generalmethods.ParseJSON;
import io.restassured.response.Response;
import org.junit.Test;

public class TestGetInventory {
    StoreMethods storeMethods = new StoreMethods();
    CreateOrderRequest createOrderRequest = new CreateOrderRequest();
    AssertResponse assertResponse = new AssertResponse();

    @Test
    public void TestStoreInventory() {
        Response response = storeMethods.canGetStoreInventory("store/inventory");
        assertResponse.canAssertResponseStatus(200,response.getStatusCode());
    }
    @Test
    public void getStoreInventory() {

        storeMethods.canGetInventoryAndAssertResponse("store/inventory",200);
    }
    @Test
    public void getStoreInventoryInvalidEndPoint() {

        storeMethods.canGetInventoryAndAssertResponse("store/invent",404);
    }
}
