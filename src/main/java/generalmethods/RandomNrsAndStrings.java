package generalmethods;

import org.junit.Test;

import java.util.Random;

public class RandomNrsAndStrings {

    public String canGenerateRandomTenCharLongString() {
//    @Test
//    public void canGenerateRandomTenCharLongString() {
//    Pramod : Reusing this method from : https://www.baeldung.com/java-random-string
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();

        System.out.println(generatedString);
        return generatedString;
    }
    @Test
    public Integer canGenerateRandomInteger() {
        Random generateRandom = new Random();
        int randomInteger = generateRandom.nextInt(1000000);
        System.out.println("Random Integer : " + randomInteger);
        return randomInteger;
    }
}
