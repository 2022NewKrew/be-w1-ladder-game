import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Ladder {
    private int numberOfGamers;
    private int heightOfLadder;

    private final String BAR = "-";
    private final String BLANK = " ";

    ArrayList<ArrayList<Boolean>> ladder = new ArrayList<ArrayList<Boolean>>();

    Ladder() {
        makeLadder();
        for(int i = 0 ; i < heightOfLadder ; i++) {
            ladder.add(makeRow());
        }
    }

    private void makeLadder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        numberOfGamers = scanner.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        heightOfLadder = scanner.nextInt();
    }

    private ArrayList<Boolean> makeRow() {
        Random random = new Random();
        ArrayList<Boolean> row = new ArrayList<Boolean>();
        for(int i = 0 ; i < numberOfGamers - 1 ; i++) {
            row.add(random.nextBoolean());
        }
        return row;
    }

    public void printLadder() {
        for(int i = 0 ; i < heightOfLadder ; i++) {
            printLadderRow(i);
            System.out.println();
        }
    }

    private void printLadderRow(int rowNum) {
        ArrayList<Boolean> row = ladder.get(rowNum);
        System.out.print("|");
        for(int i = 0 ; i < numberOfGamers - 1 ; i++) {
            System.out.print(isLadder(row.get(i))+"|");
        }
    }

    private String isLadder(Boolean ladderBoolean) {
        if (ladderBoolean) {
            return BAR;
        }
        return BLANK;
    }
}