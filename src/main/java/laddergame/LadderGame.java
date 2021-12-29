package laddergame;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LadderGame {

    private Scanner scanner = new Scanner(System.in);

    private Ladder ladder;
    private List<User> users;

    public void makeLadder(int userCount, int ladderCount) {
        this.ladder = new Ladder(userCount, ladderCount);
    }

    public void printLadderBoard() {
        printUserName();
        printLadder(ladder.getLadderCount());
    }

    private void printUserName() {
        for (User user : users) {
            System.out.printf("%-6s", user.getName());
        }
        System.out.println();
    }

    private void printLadder(int ladderCount) {
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

    public void readUserName() throws Exception {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] splitUser = scanner.nextLine().split(",");

        makeUsers(splitUser);
    }

    public void makeUsers(String[] splitUser) throws Exception{
        List<User> users = Arrays.stream(splitUser)
                .map(User::new)
                .filter(User::isValidUserNameLength)
                .collect(Collectors.toList());

        if (users.size() != splitUser.length) {
            throw new Exception("사람의 이름은 최대 5글자 입니다.");
        }

        this.users = users;
    }

    public Integer getUserCount() {
        return users.size();
    }
}
