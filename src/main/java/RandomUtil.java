import java.util.Random;

public enum RandomUtil {
    INSTANCE;

    private static final Random random=new Random();

    private RandomUtil() {}

    public boolean generateBoolean(){
        return random.nextBoolean();
    }
}
