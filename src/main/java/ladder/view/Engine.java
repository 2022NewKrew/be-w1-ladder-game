package main.java.ladder.view;

import main.java.ladder.domain.Ladder;
import main.java.ladder.domain.User;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Engine {
    static final int MAX_NAME_LEN = 5;

    public List<User> inputUsers() {
        final String DELIMITER = ",";
        Scanner scanner = new Scanner(System.in);

        System.out.printf("참여할 사람 이름을 입력하세요. (이름은 쉼표(%s)로 구분하세요)%n", DELIMITER);
        return Arrays.stream(scanner.nextLine().split(DELIMITER)).map(User::new).collect(Collectors.toList());
    }

    public int inputLadderHeight() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    public void showLadder(Ladder ladder) {
        System.out.println(ladder);
    }

    public void printUsers(List<User> users) {
        final String PRINT_FORMAT = "%-" + MAX_NAME_LEN + "." + MAX_NAME_LEN + "s ";

        StringBuilder builder = new StringBuilder();
        for (User user : users) {
            builder.append(String.format(PRINT_FORMAT, user));
        }
        System.out.println(builder);
    }
}

