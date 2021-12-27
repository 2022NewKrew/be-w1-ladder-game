package util;

public class RandomUtil {

    public static int generate() {
        double randomNumber = Math.random();
        return (int) (randomNumber*100000);
    }
}
