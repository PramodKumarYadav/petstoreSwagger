package petstore.swagger.io.store;

import domainentitites.CreateOrderRequest;
import domainentitites.StoreMethods;
import generalmethods.ParseJSON;
import org.junit.Test;

public class TestPostGetInventory {
    StoreMethods storeMethods = new StoreMethods();
    CreateOrderRequest createOrderRequest = new CreateOrderRequest();
    ParseJSON parseJSON = new ParseJSON();
    @Test
    public void searchWithNonExistingPetID() {

        storeMethods.canGetInventoryAndAssertResponse("store/inventory",200);
    }
}
