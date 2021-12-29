import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LadderGame {
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

    public String[] getParticipants() {
        return participants;
    }

    public List getLadder() {
        return ladder;
    }

    public void makeLadder() {
        for (int r = 0; r < height; r++) {
            Line line = new Line(numOfParticipants);
            ladder.add(line);
        }
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
