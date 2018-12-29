package petstore.swagger.io.store;

import domainentitites.CreateOrderRequest;
import domainentitites.StoreMethods;
import generalmethods.ParseJSON;
import org.junit.Test;

public class TestPostPlaceAnOrder {
    StoreMethods storeMethods = new StoreMethods();
    CreateOrderRequest createOrderRequest = new CreateOrderRequest();
    ParseJSON parseJSON = new ParseJSON();
    @Test
    public void postRequestWithFullRequestBody() {
        String requestBody = createOrderRequest.canCreateBasicOrderRequestBody();
        storeMethods.canPostOrderRequestByBodyAndAssertResponse("store/order",requestBody,"json",200);
    }
}
