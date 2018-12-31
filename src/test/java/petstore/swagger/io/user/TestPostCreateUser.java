package petstore.swagger.io.user;

import TestData.CreateUserRequest;
import domainentitites.UserMethods;
import org.junit.Test;

public class TestPostCreateUser {
    UserMethods userMethods = new UserMethods();
    CreateUserRequest createUserRequest = new CreateUserRequest();

    @Test
    // TODO : There seems to be issue on server side, creating users as mentioned on swagger site
    // [Ticket is still open @Swagger site.]. https://github.com/swagger-api/swagger-editor/issues/1474
    public void postRequestWithFullRequestBody() {
        String requestBody = createUserRequest.canCreateBasicUserRequestBody();
        userMethods.canCreateUserByBodyAndAssertResponse("user",requestBody,"json",200);
    }
    @Test
    public void postRequestWithCustomRequestBody() {
        String requestBody = createUserRequest.canCreateCustomUserRequestBody(27,"userPramod","Pramod","Yadav");
        userMethods.canCreateUserByBodyAndAssertResponse("user",requestBody,"json",200);
    }
    @Test
    public void postRequestWithEmptyRequestBody() {
        String requestBody = createUserRequest.canCreateEmptyUserRequestBody();
        userMethods.canCreateUserByBodyAndAssertResponse("user",requestBody,"json",200);
    }
    @Test
    public void postRequestWithBadRequestBody() {
        String requestBody = createUserRequest.canCreateBadRequestBody();
        userMethods.canCreateUserByBodyAndAssertResponse("user",requestBody,"json",400);
    }
}
