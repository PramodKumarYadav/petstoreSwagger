package petstore.swagger.io.user;

import domainentitites.UserMethods;
import org.junit.Test;

public class TestDeleteDeletesUser {
    UserMethods userMethods = new UserMethods();

    @Test
    public void tryDeleteingExistingUserByUserName() {
        userMethods.canDeleteUserByUserNameAndAssertStatus("user","user1",200);
    }
    @Test
    public void tryDeleteingNonExistingUser() {
        userMethods.canDeleteUserByUserNameAndAssertStatus("user","6281930314171690275",404);
    }
    @Test
    public void tryDeleteingInvalidUser() {
        userMethods.canDeleteUserByUserNameAndAssertStatus("user","abcdefgh",400);
    }
}
