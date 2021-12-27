package keith;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        final int num, len;
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.println("참여할 사람은 몇 명인가요?");
            num = scanner.nextInt();
            System.out.println("최대 사다리 높이는 몇 개인가요?");
            len = scanner.nextInt();
        }

        for (int i = 0; i < len; i++) {
            System.out.println(GenerateLadder(num));
        }
    }

    static StringBuilder GenerateLadder(int num) {
        ArrayList<Boolean> connection = new ArrayList<>(num - 1);
        Random random = new Random();

        for (int i = 0; i < num - 1; i++) {
            connection.add(random.nextBoolean());
        }

        return LadderToString(connection);
    }

    static StringBuilder LadderToString(ArrayList<Boolean> connection) {
        StringBuilder result = new StringBuilder();

        for (Boolean isConnected : connection) {
            result.append('|');
            result.append(isConnected ? '-' : ' ');
        }
        result.append('|');

        return result;
    }
}
