package keith;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int width, height;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("참여할 사람은 몇 명인가요?");
            width = scanner.nextInt();
            System.out.println("최대 사다리 높이는 몇 개인가요?");
            height = scanner.nextInt();
        }

        Ladder ladder = new Ladder(width, height);
        System.out.println(ladder);
    }
}
