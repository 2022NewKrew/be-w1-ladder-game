package Ladder3.View;

import java.util.Scanner;

public class UserInterface {

    public String[] inputLadderCols() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return inputStringArray();
    }

    public int inputLadderRowSize() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return inputPositiveInteger();
    }

    private String[] inputStringArray() {
        final Scanner sc = new Scanner(System.in);
        return sc.nextLine().split(",");
    }

    private int inputPositiveInteger() {
        try {
            final Scanner sc = new Scanner(System.in);
            final int num = sc.nextInt();
            validatePositiveInteger(num);
            return num;
        } catch (Exception e) {
            System.out.println("양의 정수를 입력해주세요.");
            return inputPositiveInteger();
        }
    }

    private void validatePositiveInteger(int num) throws IllegalArgumentException {
        if (num <=0) {
            throw new IllegalArgumentException();
        }
    }
}
