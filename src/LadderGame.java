import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LadderGame {
    int width;
    int height;
    int people;
    List<StringBuilder> ladder = new ArrayList<>();
    private final char LUMBER = '|';
    private final char BRIDGE = '-';
    private final char SPACE = ' ';

    LadderGame() {
        Scanner sc = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        people = sc.nextInt();
        width = 2 * people - 1;
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        height = sc.nextInt();
    }

    public void makeLadder() {
        for (int r = 0; r < height; r++) {
            ladder.add(singleRow());
        }
    }

    public void printLadder() {
        for (int r = 0; r < height; r++) {
            System.out.println(ladder.get(r));
        }
    }

    // column 번호를 매개로 호출되어 적절한 ladder element를 리턴하는 메서드
    private char ladderElement(int column) {
        // column 값이 짝수라면 사다리 세로 축에 해당하므로 LADDER를 바로 리턴
        if (column % 2 == 0) {
            return LUMBER;
        }
        // Bridge로 연결된 부위인지 아닌지를 결정할 랜덤 객체
        Random random = new Random();
        if (random.nextBoolean()) {
            return BRIDGE;
        }
        return SPACE;
    }

    private StringBuilder singleRow() {
        StringBuilder row = new StringBuilder();
        for (int c = 0; c < width; c++) {
            row.append(ladderElement(c));
        }
        return row;
    }
}
