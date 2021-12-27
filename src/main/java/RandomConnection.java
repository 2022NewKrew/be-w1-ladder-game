import java.util.Random;

public class RandomConnection {
    private static final Random random = new Random();

    public static String randomConnection() {
        return random.nextInt(10) > 4 ? "-" : " ";
    }
}
