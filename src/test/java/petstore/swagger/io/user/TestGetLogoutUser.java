package petstore.swagger.io.user;

import domainentitites.CreateOrderRequest;
import domainentitites.StoreMethods;
import domainentitites.UserMethods;
import generalmethods.ParseJSON;
import org.junit.Test;

public class TestGetLogoutUser {
    UserMethods userMethods = new UserMethods();
    CreateOrderRequest createOrderRequest = new CreateOrderRequest();
    ParseJSON parseJSON = new ParseJSON();

    @Test
    public void logoutCurrentUserSession() {

        userMethods.canLogoutUserAndAssertResponse("user/logout",200);
    }
    @Test
    public void logoutCurrentUserSessionInvalidEndPoint() {

        userMethods.canLogoutUserAndAssertResponse("user/logoutttttt",500);
    }
}
