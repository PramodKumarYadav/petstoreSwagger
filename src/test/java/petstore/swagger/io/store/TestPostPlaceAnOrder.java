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
    public void postRequestWithEmptyRequestBody() {
        String requestBody = createOrderRequest.canCreateEmptyOrderRequestBody();
        storeMethods.canPostOrderRequestByBodyAndAssertResponse("store/order",requestBody,"json",405);
    }
    @Test
    public void postRequestWithBadRequestBody() {
        String requestBody = createOrderRequest.canCreateBadRequestBody();
        storeMethods.canPostOrderRequestByBodyAndAssertResponse("store/order",requestBody,"json",400);
    }
    @Test
    public void postRequestWithFullRequestBody() {
        String requestBody = createOrderRequest.canCreateBasicOrderRequestBody();
        storeMethods.canPostOrderRequestByBodyAndAssertResponse("store/order",requestBody,"json",200);
    }
    @Test
    public void postRequestWithCustomRequestBody() {
        String requestBody = createOrderRequest.canCreateCustomOrderRequestBody(9,27,12,"placed", true);
        storeMethods.canPostOrderRequestByBodyAndAssertResponse("store/order",requestBody,"json",200);
    }
    @Test
    public void postRequestWithInvalidRequestBody() {
        String requestBody = createOrderRequest.canCreateCustomOrderRequestBody(9,27,12,"somethingNotInList", true);
        storeMethods.canPostOrderRequestByBodyAndAssertResponse("store/order",requestBody,"json",406);
    }

}
