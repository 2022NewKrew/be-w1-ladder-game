package ladder;

import exception.OutOfInputStringException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LadderGameServiceImpl implements LadderGameService {

    private final int MAX_INPUT_PARTICIPANT_NAME_LENGTH = 5;
    private LadderGameView ladderGameView;
    private LadderSimpleGame ladderSimpleGame;
    private int numberOfParticipants;
    private int ladderHeight;
    private String[] participants;

    @Override
    public void run() {
        inputLadderConsole();
        checkInvalidNameLength();
        createLadder();
        printLadder();
    }

    private void createLadder() {
        ladderSimpleGame = new LadderSimpleGame();
        ladderSimpleGame.setNumberOfParticipants(numberOfParticipants);
        ladderSimpleGame.setLadderHeight(ladderHeight);
        ladderSimpleGame.setParticipants(participants);
        ladderSimpleGame.createBridge();

        ladderGameView = new LadderGameViewConsole(ladderSimpleGame);
    }

    private void printLadder() {
        ladderGameView.printView();
    }

    private void inputLadderConsole() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        try {

            System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
            participants = bufferedReader.readLine().split(",");

            System.out.println("\n최대 사다리 높이는 몇 개인가요?");
            ladderHeight = Integer.parseInt(bufferedReader.readLine());

            numberOfParticipants = participants.length;

        } catch (IOException exception) {
            System.err.println("error message : " + exception.getMessage());
        }
    }

    private void checkInvalidNameLength() {
        for(String participant : participants) {
            if(participant.length() > MAX_INPUT_PARTICIPANT_NAME_LENGTH) {
                throw new OutOfInputStringException("참가자 수의 이름은 최대 5개 입니다.");
            }
        }
    }
}
