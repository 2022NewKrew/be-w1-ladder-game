import java.util.ArrayList;
import java.util.Random;

public class Ladder {
    private int numberOfGamers;
    private int heightOfLadder;

    ArrayList<ArrayList<Boolean>> ladder = new ArrayList<ArrayList<Boolean>>();

    Ladder(int n, int h) {
        numberOfGamers = n;
        heightOfLadder = h;
        for(int i = 0 ; i < heightOfLadder ; i++) {
            ladder.add(makeRow());
        }
    }

    public ArrayList<Boolean> makeRow() {
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
            return "-";
        }
        return " ";
    }
}