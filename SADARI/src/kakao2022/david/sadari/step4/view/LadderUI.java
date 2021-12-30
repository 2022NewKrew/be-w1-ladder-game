package kakao2022.david.sadari.step4.view;

import kakao2022.david.sadari.step4.domain.Line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LadderUI {

    private static final Scanner scanner = new Scanner(System.in);

    public static ArrayList<String> inputPeople() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return (ArrayList<String>) Arrays.asList(scanner.next().split(","));
    }

    public static int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    public static void printPeopleList(ArrayList<String> peopleList) {
        for (String person : peopleList) {
            System.out.printf("%-6s", person);
        }
        System.out.println();
    }

    public static void printLadder(ArrayList<Line> ladderBoard) {
        for (Line line : ladderBoard) {
            printLadderRow(line.getPoints());
        }
    }

    private static void printLadderRow(ArrayList<Boolean> points) {
        StringBuilder ladderLine = new StringBuilder("  |");
        for (boolean point : points) {
            ladderLine.append(getLadderRow(point));
            ladderLine.append("|");
        }
        System.out.println(ladderLine);
    }

    private static String getLadderRow(boolean point) {
        return point ? "-----" : "     ";
    }
}
