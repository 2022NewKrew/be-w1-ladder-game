package Ladder3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ladder {

    private final int height;
    private final String[] people;
    private final ArrayList<Line> ladderLines = new ArrayList<>();

    private final Scanner sc = new Scanner(System.in);
    private final Random rd = new Random();

    Ladder() {
        people = inputLadderCols();
        height = inputLadderRowSize();

        for (int i = 0; i < height; i++)
            ladderLines.add(new Line(people.length));
    }

    private String[] inputLadderCols() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return inputStringArray();
    }

    private int inputLadderRowSize() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return inputPositiveInteger();
    }

    private String[] inputStringArray() {
        return sc.nextLine().split(",");
    }

    private int inputPositiveInteger() {
        try {
            final int num = sc.nextInt();
            if (num <= 0) throw new RuntimeException();
            return num;
        } catch (Exception e) {
            System.out.println("양의 정수를 입력해주세요.");
            return inputPositiveInteger();
        }
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();

        builder.append("\n");  // 시각적 구분을 위한 한줄 공백
        builder.append(drawNameRow() + "\n");
        builder.append(drawLadder());

        return builder.toString();
    }

    private String drawNameRow() {
        return Arrays.asList(people).stream()
            .map(person -> getNameTag(person))
            .collect(Collectors.joining(" "));
    }

    private String getNameTag(String name) {
        String nameTag;
        switch (name.length()) {
            case 0: nameTag = "     "; break;
            case 1: nameTag = "  " + name + "  "; break;
            case 2: nameTag = "  " + name + " "; break;
            case 3: nameTag = " " + name + " "; break;
            case 4: nameTag = " " + name; break;
            default: nameTag = name.substring(0, 5);
        }
        return nameTag;
    }

    private String drawLadder() {
        return ladderLines.stream()
            .map(line -> line.toString())
            .collect(Collectors.joining("\n"));
    }
}
