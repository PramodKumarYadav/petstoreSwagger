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
    // As per interface giving more than 10 is not allowed in webApplication (however it is allowed in API)
    public void searchWithExistingOrderIDMoreThan10() {

        String requestBody = createOrderRequest.canCreateCustomOrderRequestBody(11,27,12,"placed", true);
        storeMethods.canPostOrderRequestByBodyAndAssertResponse("store/order",requestBody,"json",200);

        // Get request ID
        String orderID = parseJSON.canReturnAKeyValuefromJSONStringBody(requestBody.toString(),"id","Search using ");

        // Assert that id is found (response code 200)
        storeMethods.canGetOrderByIDAndAssertStatus("store/order",orderID,200);
    }
    @Test
    public void searchWithIncorrectEndPoint() {

        // Assert that id is found (response code 200)
        storeMethods.canGetOrderByIDAndAssertStatus("store/ord","11",404);
    }
    @Test
    public void searchWithEmptyOrderID() {

        // Assert that id is found (response code 200)
        storeMethods.canGetOrderByIDAndAssertStatus("store/order","",405);
    }
    @Test
    public void searchWithInvalidOrderID() {

        // Assert that id is found (response code 200)
        storeMethods.canGetOrderByIDAndAssertStatus("store/order","abd#$%",404);
    }
    @Test
    public void searchWithNonExistingOrderID() {

        // Assert that id is found (response code 200)
        storeMethods.canGetOrderByIDAndAssertStatus("store/order","44234232523424234234211342347886",404);
    }
}
