package keith;

import java.util.Scanner;

public class InputManager {
    public static final int width, height;
    static {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("참여할 사람은 몇 명인가요?");
            width = scanner.nextInt();
            checkWidth(width);

            System.out.println("최대 사다리 높이는 몇 개인가요?");
            height = scanner.nextInt();
            checkHeight(height);
        }
    }

    public static void checkWidth(int width) {
        if (width < 1) {
            throw new IllegalArgumentException("사다리 높이는 1개 이상이어야 합니다!");
        }
    }

    public static void checkHeight(int height) {
        if (height < 1) {
            throw new IllegalArgumentException("사다리 높이는 1개 이상이어야 합니다!");
        }
    }
}
