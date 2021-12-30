import java.util.Random;

public class RandomFlag {
    private static Random random = new Random();

    public RandomFlag() {
    }

    public Boolean getRandomFlag() {
        return random.nextBoolean();
    }
}