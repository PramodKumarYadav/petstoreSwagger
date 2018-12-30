package domainentitites;

import generalmethods.RandomNrsAndStrings;
import projectconfiguration.TestEnvironment;

public class CreateUserRequest {

    TestEnvironment testEnv = new TestEnvironment();
    RandomNrsAndStrings randomNrsAndStrings = new RandomNrsAndStrings();

    public String canCreateEmptyUserRequestBody() {
        String  requestBody = "{\n" +
                "}";
        System.out.println("requestBody" + requestBody);
        return requestBody;
    }
    public String canCreateBadRequestBody() {
        String  requestBody = "{{\n" +
                "  \"id\": "+ randomNrsAndStrings.canGenerateRandomInteger(1000) +",\n" +
                "}";
        System.out.println("requestBody" + requestBody);
        return requestBody;
    }
    public String canCreateBasicUserRequestBody() {
        String  requestBody = "{\n" +
                "  \"id\": "+ randomNrsAndStrings.canGenerateRandomInteger(1000) +",\n" +
                "  \"username\": \""+ randomNrsAndStrings.canGenerateRandomString(5) +"\",\n" +
                "  \"firstName\": \""+ randomNrsAndStrings.canGenerateRandomString(7) +"\",\n" +
                "  \"lastName\": \""+ randomNrsAndStrings.canGenerateRandomString(9) +"\",\n" +
                "  \"email\": \""+ "PramodYadavdummyemail@gmail.com" +"\",\n" +
                "  \"password\": \""+ "431108055" +"\",\n" +
                "  \"phone\": \""+ "0987654321" +"\",\n" +
                "  \"userStatus\": "+ randomNrsAndStrings.canGenerateRandomInteger(10) +",\n" +
                "}";
        System.out.println("requestBody" + requestBody);
        return requestBody;
    }
    public String canCreateCustomUserRequestBody(int id, String username, String firstName, String lastName) {
        String  requestBody = "{\n" +
                "  \"id\": "+ id +",\n" +
                "  \"username\": \""+ username +"\",\n" +
                "  \"firstName\": \""+ firstName +"\",\n" +
                "  \"lastName\": \""+ lastName +"\",\n" +
                "  \"email\": \""+ "PramodYadavdummyemail@gmail.com" +"\",\n" +
                "  \"password\": \""+ "431108055" +"\",\n" +
                "  \"phone\": \""+ "0987654321" +"\",\n" +
                "  \"userStatus\": "+ randomNrsAndStrings.canGenerateRandomInteger(10) +",\n" +
                "}";
        System.out.println("requestBody" + requestBody);
        return requestBody;
    }
}
