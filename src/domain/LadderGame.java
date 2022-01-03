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
    private List<String> results;
    private List<String> gameResult;
    private List<Line> ladder = new ArrayList<>();

    private Scanner scanner = new Scanner(System.in);

    public LadderGame(Boolean startGame) {
        if (startGame) {
            inputParticipants();
            inputResult();
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

    public List<String> getResults() {
        return results;
    }

    public List<String> getGameResult() {
        return gameResult;
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

    public void executeGame() {
        gameResult = new ArrayList<>();
        for (int i = 0; i < numOfParticipants; i++) {
            int singleResult = getSingleResult(i);
            gameResult.add(results.get(singleResult));
        }
    }

    private int getSingleResult(int participantIndex) {
        int singleResult = participantIndex;
        for (int i = 0; i < height; i++) {
            singleResult = getNextLumber(singleResult, i);
        }
        return singleResult;
    }

    private int getNextLumber(int nowLumber, int nowHeight) {
        Line nowLine = ladder.get(nowHeight);
        if (nowLumber == 0 && nowLine.getPoints().get(nowLumber)) {
            return 1;
        }
        if (nowLumber == 0 && !nowLine.getPoints().get(nowLumber)) {
            return 0;
        }
        if (nowLumber == nowLine.getLength() && nowLine.getPoints().get(nowLumber - 1)) {
            return nowLumber - 1;
        }
        if (nowLumber == nowLine.getLength() && !nowLine.getPoints().get(nowLumber - 1)) {
            return nowLumber;
        }
        if (nowLine.getPoints().get(nowLumber - 1)) {
            return nowLumber - 1;
        }
        if (nowLine.getPoints().get(nowLumber)) {
            return nowLumber + 1;
        }
        return nowLumber;
    }


    private void inputParticipants() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String inputLine = scanner.nextLine();
        participants = Arrays.asList(inputLine.split(","));
    }

    private void inputResult() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String inputLine = scanner.nextLine();
        results = Arrays.asList(inputLine.split(","));
    }

    private void inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        height = scanner.nextInt();
    }

}
