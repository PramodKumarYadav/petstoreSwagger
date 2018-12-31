package petstore.swagger.io.user;

import TestData.CreateUserRequest;
import domainentitites.UserMethods;
import org.junit.Test;

public class TestPostCreateUsersWithList {
    UserMethods userMethods = new UserMethods();
    CreateUserRequest createUserRequest = new CreateUserRequest();
    @Test
    // TODO : There seems to be issue on server side, creating users as mentioned on swagger site
    // [Ticket is still open @Swagger site.]. https://github.com/swagger-api/swagger-editor/issues/1474
    public void postRequestWithFullRequestBody() {
        String requestBody = createUserRequest.canCreateListOfUsersRequestBody(3);
        userMethods.canCreateUserByBodyAndAssertResponse("user/createWithList",requestBody,"json",200);
    }
}
