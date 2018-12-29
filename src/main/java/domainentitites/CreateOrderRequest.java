package domainentitites;

public class CreateOrderRequest {

    public String canCreateBasicOrderRequestBody() {
//
        //@Test
        //public void canCreatePetRequestBody() {
        //Integer id = 1589257;
        //String name = "BillyTheDog";
        //Integer categoryID = id +1;
        //String cataegoryName = "BullDog";
        //List<String> photoUrls = new ArrayList<>();
        //List<String> tags = new ArrayList<>();
        //String status = "sold";

        String  requestBody = "{\n" +
                "  \"id\": 9,\n" +
                "  \"petId\": 27,\n" +
                "  \"quantity\": 270,\n" +
                "  \"shipDate\": \"2018-12-29T17:35:00.479Z\",\n" +
                "  \"status\": \"placed\",\n" +
                "  \"complete\": true\n" +
                "}";

        System.out.println("requestBody" + requestBody);
        return requestBody;
    }
}
