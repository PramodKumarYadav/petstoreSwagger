package petstore.swagger.io.user;

import domainentitites.CreateOrderRequest;
import domainentitites.UserMethods;
import generalmethods.ParseJSON;
import org.junit.Test;

public class TestGetLoginUser {
    UserMethods userMethods = new UserMethods();
    CreateOrderRequest createOrderRequest = new CreateOrderRequest();
    ParseJSON parseJSON = new ParseJSON();

    @Test
    public void LoginUserWithDefaultUserNamePasswordUsingFullQuery() {
        userMethods.canLogInUserAndAssertResponse("user/login","username=user1&password=pass@123",200);
    }
}
