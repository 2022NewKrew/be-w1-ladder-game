package main.java;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Engine {
    private int userNum;
    private int ladderHeight;
    private List<Ladder> ladders;

    public void inputUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        userNum = scanner.nextInt();
    }

    public void inputLadder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        ladderHeight = scanner.nextInt();
    }

    public void createLadders() {
        ladders = IntStream.range(0, userNum).mapToObj(e -> new Ladder(ladderHeight)).collect(Collectors.toList());
    }

    public void showLadders() {
        for (int i = 0; i < ladderHeight; i++) {
            System.out.println(printLadderLineAt(i));
        }
    }

    public String printLadderLineAt(int heightIndex) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < ladders.size(); i++) {
            LadderBrick ladderBrick = ladders.get(i).getLadderBrickAt(heightIndex);
            builder.append(Line.LADDER.line);

            if (i == ladders.size() - 1) continue;
            builder.append(ladderBrick.getLineBridge().line);
        }

        return builder.toString();
    }
}

