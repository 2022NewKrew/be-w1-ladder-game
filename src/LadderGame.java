import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LadderGame {
    private final char LUMBER = '|';
    private final char BRIDGE = '-';
    private final char SPACE = ' ';
    private final int MAX_NAME_LENGTH = 5;

    int width;
    int height;
    int numOfParticipants;
    String[] participants;
    List<Line> ladder = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    LadderGame() {
        participants = inputParticipants();
        height = inputHeight();
        numOfParticipants = participants.length;
        width = 2 * numOfParticipants - 1;
    }

    public void makeLadder() {
        for (int r = 0; r < height; r++) {
            Line line = new Line(numOfParticipants);
            ladder.add(line);
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

    private String[] inputParticipants() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String inputLine = scanner.nextLine();
        return inputLine.split(",");
    }

    private int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

}
