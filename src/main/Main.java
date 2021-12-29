package main;

import java.util.*;

public class Main {
    final static String LADDER_PILLAR = "|";
    final static String LADDER_BRIDGE = "-----";
    final static String LADDER_EMPTY = "     ";

    // 자주 쓸 것 같은 애들은 밖에다 빼놓기
    static List<String> peopleNameList;
    static int peopleCount;
    static int ladderHeight;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // 입력 받기
        getInput();

        // ladder 생성
        Ladder ladder = LadderFactory.generateLadder(peopleCount, ladderHeight);

        // ladder 출력
        printLadder(ladder);
    }

    public static void getInput() {
        while (true) {
            try {
                System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
                String nameList = sc.nextLine();
                peopleNameList = new ArrayList<>(Arrays.asList(nameList.split(",")));
                peopleCount = peopleNameList.size();
                System.out.println("최대 사다리 높이는 몇 개인가요?");
                ladderHeight = sc.nextInt();
                if (peopleCount < 1 || ladderHeight < 1) throw new InputMismatchException();
                break;
            } catch (InputMismatchException e) {
                System.out.println("잘못 된 입력입니다. 다시 입력해주세요.\n");
                sc.next();
            }
        }
    }

    public static void printLadder(Ladder ladder) {
        for (String name : peopleNameList) {
            String sortedName = center(6, name);
            System.out.print(sortedName);
        }

        System.out.println();
        List<Line> lines = ladder.getLines();
        for (int i = 0; i < ladder.getLadderHeight(); i++) {
            System.out.print("  ");
            printLine(lines.get(i));
        }
    }

    public static void printLine(Line line) {
        StringBuilder sb = new StringBuilder();
        List<Boolean> points = line.getPoints();
        for (int i = 0; i < points.size() - 1; i++) {
            if (points.get(i) == Line.BRIDGE_ON_THE_RIGHT) {
                sb.append(LADDER_PILLAR);
                sb.append(LADDER_BRIDGE);
                continue;
            }
            sb.append(LADDER_PILLAR);
            sb.append(LADDER_EMPTY);
        }

        sb.append(LADDER_PILLAR);
        System.out.println(sb);
    }

    public static String center(int totalLength, String originStr) {
        StringBuilder sb = new StringBuilder();
        int diffLength = totalLength - originStr.length();
        int prefixCount = (int) (diffLength / 2);
        int suffixCount = diffLength - prefixCount;

        sb.append(" ".repeat(prefixCount));
        sb.append(originStr);
        sb.append(" ".repeat(suffixCount));
        return sb.toString();
    }
}
