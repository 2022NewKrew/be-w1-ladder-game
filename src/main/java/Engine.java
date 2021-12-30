package main.java;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Engine {
    static final int MAX_NAME_LEN = 5;
    private List<String> users;
    private int ladderHeight;
    private Ladder ladder;

    public void inputUser() {
        final String DELIMITER = ",";
        Scanner scanner = new Scanner(System.in);
        System.out.printf("참여할 사람 이름을 입력하세요. (이름은 쉼표(%s)로 구분하세요)%n", DELIMITER);
        users = Arrays.asList(scanner.nextLine().split(DELIMITER));
    }

    public void inputLadder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        ladderHeight = scanner.nextInt();
    }

    public void createLadders() {
        ladder = new Ladder(users.size(), ladderHeight);
    }

    public void showLadders() {
        System.out.println(ladder);
    }

    public void printUsers() {
        final String PRINT_FORMAT = "%-" + MAX_NAME_LEN + "." + MAX_NAME_LEN + "s ";

        StringBuilder builder = new StringBuilder();
        for (String user : users) {
            builder.append(String.format(PRINT_FORMAT, user));
        }
        System.out.println(builder);
    }
}

