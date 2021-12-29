import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LadderGame {
    private static final int MAX_GAME_LENGTH = 5;

    private int height;
    private int numOfParticipants;
    private List<String> participants;
    private List<Line> ladder = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    LadderGame() {
        participants = inputParticipants();
        height = inputHeight();
        numOfParticipants = participants.size();
    }

    public int getMaxNameLength() {
        return MAX_GAME_LENGTH;
    }

    public int getHeight() {
        return height;
    }

    public int getNumOfParticipants() {
        return numOfParticipants;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public List<Line> getLadder() {
        return ladder;
    }

    public void makeLadder() {
        for (int r = 0; r < height; r++) {
            Line line = new Line(numOfParticipants);
            ladder.add(line);
        }
    }

    private List<String> inputParticipants() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String inputLine = scanner.nextLine();
        List<String> participants = new ArrayList<>(Arrays.asList(inputLine.split(",")));
        return participants;
    }

    private int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

}
