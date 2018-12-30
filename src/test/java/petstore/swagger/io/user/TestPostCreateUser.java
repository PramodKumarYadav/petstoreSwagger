package petstore.swagger.io.user;

import domainentitites.CreateUserRequest;
import domainentitites.UserMethods;
import generalmethods.ParseJSON;
import org.junit.Test;

public class TestPostCreateUser {
    UserMethods userMethods = new UserMethods();
    CreateUserRequest createUserRequest = new CreateUserRequest();
    ParseJSON parseJSON = new ParseJSON();

    @Test
    // TODO : There seems to be issue creating users as mentioned on swagger site [Ticket is still open.]. https://github.com/swagger-api/swagger-editor/issues/1474
    public void postRequestWithFullRequestBody() {
        String requestBody = createUserRequest.canCreateBasicUserRequestBody();
        userMethods.canCreateUserByBodyAndAssertResponse("user",requestBody,"json",200);
    }
}
