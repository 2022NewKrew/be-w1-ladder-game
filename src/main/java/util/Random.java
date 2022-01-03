package util;

public class Random {
    private static final java.util.Random random = new java.util.Random();

    public static boolean nextBoolean() {
        return random.nextBoolean();
    }
}
