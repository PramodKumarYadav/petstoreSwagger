package petstore.swagger.io.store;

import domainentitites.CreateOrderRequest;
import domainentitites.StoreMethods;
import generalmethods.ParseJSON;
import org.junit.Test;

public class TestGetInventory {
    StoreMethods storeMethods = new StoreMethods();
    CreateOrderRequest createOrderRequest = new CreateOrderRequest();
    ParseJSON parseJSON = new ParseJSON();
    @Test
    public void getStoreInventory() {

        storeMethods.canGetInventoryAndAssertResponse("store/inventory",200);
    }
    @Test
    public void getStoreInventoryInvalidEndPoint() {

        storeMethods.canGetInventoryAndAssertResponse("store/invent",404);
    }
}
