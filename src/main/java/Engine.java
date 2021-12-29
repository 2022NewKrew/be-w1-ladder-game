package main.java;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Engine {
    private List<String> users;
    private int ladderHeight;
    private List<Ladder> ladders;

    public void inputUser() {
        final int MAX_NAME_LEN = 5;
        Scanner scanner = new Scanner(System.in);

        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        users = Arrays.stream(scanner.nextLine().split(","))
                .map((name) -> name.length() > MAX_NAME_LEN ? name.substring(0, MAX_NAME_LEN) : name)
                .collect(Collectors.toList());
    }

    public void inputLadder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        ladderHeight = scanner.nextInt();
    }

    public void createLadders() {
        ladders = IntStream.range(0, users.size()).mapToObj(e -> new Ladder(ladderHeight)).collect(Collectors.toList());
    }

    public void showLadders() {
        printUsers();
        for (int i = 0; i < ladderHeight; i++) {
            System.out.println(printLadderLineAt(i));
        }
    }

    public void printUsers() {
        StringBuilder builder = new StringBuilder();
        for (String user : users) {
            builder.append(" ").append(user).append(" ");
        }
        System.out.println(builder);
    }

    public String printLadderLineAt(int heightIndex) {
        final String INDENT = "   ";
        StringBuilder builder = new StringBuilder(INDENT);

        for (int i = 0; i < ladders.size(); i++) {
            LadderBrick ladderBrick = ladders.get(i).getLadderBrickAt(heightIndex);
            builder.append(Line.LADDER.line);

            if (i == ladders.size() - 1) continue;
            builder.append(ladderBrick.getLineBridge().line);
        }
        return builder.toString();
    }
}

