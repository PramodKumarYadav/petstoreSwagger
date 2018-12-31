package petstore.swagger.io.user;

import TestData.CreateOrderRequest;
import domainentitites.StoreMethods;
import domainentitites.UserMethods;
import generalmethods.ParseJSON;
import org.junit.Test;

public class TestGetUserByUserName {
    UserMethods userMethods = new UserMethods();
    CreateOrderRequest createOrderRequest = new CreateOrderRequest();
    ParseJSON parseJSON = new ParseJSON();

    @Test
    // As per interface giving more than 10 is not allowed in webApplication (however it is allowed in API)
    public void searchWithExistingDefaultUserID() {

        // Assert that id is found (response code 200)
        userMethods.canGetUserByUserNameAndAssertStatus("user","user1",200);
    }
    @Test
    public void searchWithIncorrectEndPoint() {

        userMethods.canGetUserByUserNameAndAssertStatus("userrr","user1",404);
    }
    @Test
    public void searchWithEmptyUserName() {

        userMethods.canGetUserByUserNameAndAssertStatus("user","",405);
    }
    @Test
    public void searchWithInvalidUserName() {

        userMethods.canGetUserByUserNameAndAssertStatus("user","abd#$%",404);
    }
    @Test
    public void searchWithNonExistingUserName() {
        userMethods.canGetUserByUserNameAndAssertStatus("user","44234232523424234234211342347886",404);
    }
    @Test
    // TODO
    public void searchWithExistingOrderID() {

//        // First create an order to ensure that order exists
//        String requestBody = createOrderRequest.canCreateBasicOrderRequestBody();
//        userMethods.canPostOrderRequestByBodyAndAssertResponse("store/order",requestBody,"json",200);
//
//        // Get request ID
//        String orderID = parseJSON.canReturnAKeyValuefromJSONStringBody(requestBody.toString(),"id","Search using ");

        // Assert that id is found (response code 200)
//        userMethods.canGetUserByUserNameAndAssertStatus("user",orderID,200);
    }
}
