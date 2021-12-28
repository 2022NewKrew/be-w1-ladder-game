package laddergame;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static int inputNumberOfGamer() {
        System.out.println("참여할 사람은 몇 명인가요?");
        int numberOfGamer = sc.nextInt();
        validatePositive(numberOfGamer);
        return numberOfGamer;
    }

    public static int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int maxHeight = sc.nextInt();
        validatePositive(maxHeight);
        return maxHeight;
    }

    private static void validatePositive(int number) {
        if (number <= 0) {
            throw new InputMismatchException("0보다 큰 정수값을 입력해야 합니다.");
        }
    }
}
