package laddergame.view;

import laddergame.Ladder;
import laddergame.LadderComponent;
import laddergame.User;

import java.util.List;
import java.util.Scanner;

public class View {

    private Scanner scanner = new Scanner(System.in);

    public void printLadderBoard(Ladder ladder, List<User> users) {
        printUserName(users);
        printLadder(ladder);
    }

    private void printUserName(List<User> users) {
        for (User user : users) {
            System.out.printf("%-6s", user.getName());
        }
        System.out.println();
    }

    private void printLadder(Ladder ladder) {
        Integer ladderCount = ladder.getLadderCount();
        for (int i = 0; i < ladderCount; i++) {
            ladder.getLadder().get(i).forEach(this::printEachLadderComponent);
            System.out.println();
        }
    }

    private void printEachLadderComponent(LadderComponent ladderComponent) {
        if (ladderComponent.hasRightHorizon()) {
            System.out.print("|-----");
            return;
        }

        System.out.print("|     ");
    }


    public Integer readLadderCount() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    public String[] readUserName() throws IllegalArgumentException {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] splitUser = scanner.nextLine().split(",");

        for (String userName : splitUser) {
            isValidUserNameLength(userName);
        }

        return splitUser;
    }

    private Boolean isValidUserNameLength(String userName) throws IllegalArgumentException{
        if (userName.length() > 5) {
            throw new IllegalArgumentException("사람의 이름은 최대 5자 입니다.");
        }

        return true;
    }
}
