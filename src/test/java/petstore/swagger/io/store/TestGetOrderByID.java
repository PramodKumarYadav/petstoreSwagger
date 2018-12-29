package petstore.swagger.io.store;

import domainentitites.CreateOrderRequest;
import domainentitites.StoreMethods;
import generalmethods.ParseJSON;
import io.restassured.path.json.JsonPath;
import org.junit.Test;

public class TestGetOrderByID {
    StoreMethods storeMethods = new StoreMethods();
    CreateOrderRequest createOrderRequest = new CreateOrderRequest();
    ParseJSON parseJSON = new ParseJSON();

    @Test
    public void searchWithExistingOrderID() {

        // First create an order to ensure that order exists
        String requestBody = createOrderRequest.canCreateBasicOrderRequestBody();
        storeMethods.canPostOrderRequestByBodyAndAssertResponse("store/order",requestBody,"json",200);

        // Get request ID
        String orderID = parseJSON.canReturnAKeyValuefromJSONStringBody(requestBody.toString(),"id","Search using ");

        // Assert that id is found (response code 200)
        storeMethods.canGetOrderByIDAndAssertStatus("store/order",orderID,200);
    }
    @Test
    public void searchWithExistingOrderIDMoreThan10() {

        // Assert that id is found (response code 200)
        storeMethods.canGetOrderByIDAndAssertStatus("store/order","11",200);
    }
}
