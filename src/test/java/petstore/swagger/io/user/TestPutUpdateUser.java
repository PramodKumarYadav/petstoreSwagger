package petstore.swagger.io.user;

import TestData.CreateUserRequest;
import domainentitites.UserMethods;
import org.junit.Test;

public class TestPutUpdateUser {
    UserMethods userMethods = new UserMethods();
    CreateUserRequest createUserRequest = new CreateUserRequest();

    @Test
    public void putRequestUpdateRandomDataStatusAvailable() {
        String requestBody = createUserRequest.canCreateCustomUserRequestBody(123,"user1","pramod","yadav");
        userMethods.canUpdateUserByBodyAndPathAndAssertResponse("user","user1",requestBody,"json",200);
    }
    @Test
    public void putRequestUpdateEmptyStatusAvailable() {
        String requestBody = createUserRequest.canCreateCustomUserRequestBody(123,"user1","","");
        userMethods.canUpdateUserByBodyAndPathAndAssertResponse("user","user1",requestBody,"json",200);
    }
}
