package laddergame.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleInputView implements InputView {
    private static final Scanner sc = new Scanner(System.in);
    private static final String SPLIT_REGEX = ",";

    public String[] inputPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] playerNames = sc.nextLine().split(SPLIT_REGEX);
        return playerNames;
    }

    public int inputLadderHeight() {
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
