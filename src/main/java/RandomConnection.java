import java.util.Random;

public class RandomConnection {
    public static String randomConnection() {
        Random random = new Random();
        int value = random.nextInt(10);
        return value > 4 ? "-" : " ";
    }
}
