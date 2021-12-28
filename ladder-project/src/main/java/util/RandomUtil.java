package util;

public final class RandomUtil {

    //기본 생성자가 만들어지는 것을 막는다(인스턴스화 방지용)
    private RandomUtil() {
        throw new AssertionError();
    }

    public static int generate() {
        double randomNumber = Math.random();
        return (int) (randomNumber * 100000);
    }

    public static int generateSpecificRange(int range) {
        return generate() % range;
    }
}
