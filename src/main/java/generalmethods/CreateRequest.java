package generalmethods;

import org.junit.Test;
import projectconfiguration.TestEnvironment;

import java.util.Random;

public class CreateRequest {
    TestEnvironment testEnv = new TestEnvironment();
    RandomNrsAndStrings randomNrsAndStrings = new RandomNrsAndStrings();

    public String canCreateEmptyPetRequestBody() {

        String  requestBody = "{\n" +
                "}";

        System.out.println("requestBody" + requestBody);
        return requestBody;
    }

    public String canCreateBasicPetRequestBody() {
//        @Test
//    public void canCreatePetRequestBody() {
//        Integer id = 1589257;
//        String name = "BillyTheDog";
//        Integer categoryID = id +1;
//        String cataegoryName = "BullDog";
//        List<String> photoUrls = new ArrayList<>();
//        List<String> tags = new ArrayList<>();
//        String status = "sold";

        String  requestBody = "{\n" +
                "  \"id\": "+ randomNrsAndStrings.canGenerateRandomInteger() +",  \n" +
                "  \"name\": \"" + randomNrsAndStrings.canGenerateRandomTenCharLongString() + "\",\n" +
                "  \"category\": {\n" +
                "    \"id\": "+ randomNrsAndStrings.canGenerateRandomInteger() +",\n" +
                "    \"name\": \"BullDog\"\n" +
                "  },\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": "+ randomNrsAndStrings.canGenerateRandomInteger() +",\n" +
                "      \"name\": \"byPramodYadav\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";

        System.out.println("requestBody" + requestBody);
        return requestBody;
    }
    public String canCreateFullPetRequestBody() {
//        @Test
//    public void canCreatePetRequestBody() {
//        Integer id = 1589257;
//        String name = "BillyTheDog";
//        Integer categoryID = id +1;
//        String cataegoryName = "BullDog";
//        List<String> photoUrls = new ArrayList<>();
//        List<String> tags = new ArrayList<>();
//        String status = "sold";
        Random generateRandom = new Random();

        long randomLongID = generateRandom.nextLong();
        int randomIntCategoryID = generateRandom.nextInt(1000);
        int randomIntTag = generateRandom.nextInt(1000);
        System.out.println("id : " + randomLongID);

        String  requestBody = "{\n" +
                "  \"id\": "+ randomNrsAndStrings.canGenerateRandomInteger() +",  \n" +
                "  \"name\": \"" + randomNrsAndStrings.canGenerateRandomTenCharLongString() + "\",\n" +
                "  \"category\": {\n" +
                "    \"id\": "+ randomNrsAndStrings.canGenerateRandomInteger() +",\n" +
                "    \"name\": \"BullDog\"\n" +
                "  },\n" +
                "  \"photoUrls\": [\n" +
                "     \"http://porodasobak.net/img/uploads/2014/08/1291.jpg\" ," +
                "     \"https://www.ptichka.ru/data/cache/2018mar/19/03/64590_14562.jpg\" " +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": "+ randomNrsAndStrings.canGenerateRandomInteger() +",\n" +
                "      \"name\": \"byPramodYadavTag1\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": "+ randomNrsAndStrings.canGenerateRandomInteger() +",\n" +
                "      \"name\": \"byPramodYadavTag2\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";

        System.out.println("requestBody" + requestBody);
        return requestBody;
    }
}

