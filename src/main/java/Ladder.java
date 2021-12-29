import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ladder {

    private int PLAYER_NUMBER;
    private int LADDER_HEIGHT;
    private final List<Line> LINE_LIST = new ArrayList<>();

    public Ladder() {
        getLadderInfo();
        setLineList();
    }

    private void getLadderInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        PLAYER_NUMBER = sc.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        LADDER_HEIGHT = sc.nextInt();
    }

    private void setLineList() {
        for (int i = 0; i < LADDER_HEIGHT; i++) {
            LINE_LIST.add(new Line(PLAYER_NUMBER));
        }
    }

    public void printLadder() {
        for (int i = 0; i < LADDER_HEIGHT; i++) {
            LINE_LIST.get(i).printLine();
        }
    }
}
