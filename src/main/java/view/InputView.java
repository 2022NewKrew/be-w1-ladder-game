package main.java.view;

import java.util.*;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static List<String> inputPeople() {
        List<String> peopleNameList;
        while (true) {
            try {
                System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
                String nameList = scanner.nextLine();
                peopleNameList = new ArrayList<>(Arrays.asList(nameList.split(",")));
                if (peopleNameList.size() < 1) throw new InputMismatchException();
                break;
            } catch (InputMismatchException e) {
                System.out.println("잘못 된 입력입니다. 다시 입력해주세요.\n");
                scanner.next();
            }
        }
        return peopleNameList;
    }

    public static int inputLadderHeight() {
        int ladderHeight;
        while (true) {
            try {
                System.out.println("최대 사다리 높이는 몇 개인가요?");
                ladderHeight = scanner.nextInt();
                if (ladderHeight < 1) throw new InputMismatchException();
                break;
            } catch (InputMismatchException e) {
                System.out.println("잘못 된 입력입니다. 다시 입력해주세요.\n");
                scanner.next();
            }
        }
        return ladderHeight;
    }
}
