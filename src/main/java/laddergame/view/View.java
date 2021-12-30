package laddergame.view;

import laddergame.domain.Ladder;
import laddergame.domain.LadderComponent;
import laddergame.domain.User;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class View {

    private Scanner scanner = new Scanner(System.in);

    private static final String SPLIT_DELIMITER = ",";
    private final static Integer MAX_LENGTH_USER_NAME = 5;

    public void printLadderBoard(Ladder ladder, List<User> users, List<String> gameResult) {
        printUserName(users);
        printLadder(ladder);
        printGameResult(gameResult);
        System.out.println();
    }

    private void printUserName(List<User> users) {
        for (User user : users) {
            System.out.printf("%-6s", user.getName());
        }
        System.out.println();
    }

    private void printLadder(Ladder ladder) {
        for (List<LadderComponent> ladderComponents : ladder.getLadder()) {
            ladderComponents.forEach(this::printEachLadderComponent);
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
        return Integer.parseInt(scanner.nextLine());
    }

    public List<String> readUserName() throws IllegalArgumentException {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        List<String> splitUser = Arrays.asList(scanner.nextLine().split(SPLIT_DELIMITER));

        for (String userName : splitUser) {
            validateUserNameLength(userName);
        }

        return splitUser;
    }

    private void validateUserNameLength(String userName) throws IllegalArgumentException {
        if (userName.length() > MAX_LENGTH_USER_NAME) {
            throw new IllegalArgumentException("사람의 이름은 최대 " + MAX_LENGTH_USER_NAME + "자 입니다.");
        }
    }

    public List<String> readGameResultText() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요");
        return Arrays.asList(scanner.nextLine().split(SPLIT_DELIMITER));
    }

    public void printGameResult(List<String> gameResults) {
        for (String gameResult : gameResults) {
            System.out.printf("%-6s", gameResult);
        }
        System.out.println();
    }

    public String readUserNameForGameResult() {
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }

    public void printGameResultOfEachUser(Map<String, String> gameResults, String userName) {
        System.out.println("실행결과");
        String gameResult = gameResults.get(userName);

        if (gameResult == null) {
            System.out.println("입력하신 사용자는 존재하지 않습니다.");
            return;
        }

        System.out.println(gameResult);
        System.out.println();
    }

    public void printGameResultOfAllUser(Map<String, String> gameResults) {
        for (Map.Entry<String, String> gameResultEntry : gameResults.entrySet()) {
            System.out.print(gameResultEntry.getKey() + " : ");
            System.out.println(gameResultEntry.getValue());
        }
        System.out.println();
    }

    public void printEndGameComment() {
        System.out.println("게임을 종료합니다.");
    }
}
