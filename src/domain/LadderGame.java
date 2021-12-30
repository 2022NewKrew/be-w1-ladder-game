package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LadderGame {
    private static final int MAX_NAME_LENGTH = 5;

    private int height;
    private int numOfParticipants;
    private List<String> participants;
    private List<Line> ladder = new ArrayList<>();

    private Scanner scanner = new Scanner(System.in);

    public LadderGame() { }
    public LadderGame(Boolean startGame) {
        if (startGame) {
            inputParticipants();
            inputHeight();
            numOfParticipants = participants.size();
        }
    }

    public int getMaxNameLength() {
        return MAX_NAME_LENGTH;
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

    private void inputParticipants() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String inputLine = scanner.nextLine();
        participants = Arrays.asList(inputLine.split(","));
    }

    private void inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        height = scanner.nextInt();
    }

}
