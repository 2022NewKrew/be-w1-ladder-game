import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LadderGameServiceImpl implements LadderGameService {

    private LadderSimpleGame ladderSimpleGame;
    private int numberOfParticipants;
    private int ladderHeight;

    @Override
    public void run() {
        inputLadder();
        createLadder();
        printLadder();
    }

    private void createLadder() {
        ladderSimpleGame = new LadderSimpleGame();
        ladderSimpleGame.setNumberOfParticipants(numberOfParticipants);
        ladderSimpleGame.setLadderHeight(ladderHeight);
        ladderSimpleGame.createBridge();
    }

    private void printLadder() {
        System.out.println(ladderSimpleGame.getLadderString());
    }

    private void inputLadder() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("참여할 사람은 몇명인가요?");
            numberOfParticipants = Integer.parseInt(bufferedReader.readLine());

            System.out.println("최대 사다리 높이는 몇 개인가요?");
            ladderHeight = Integer.parseInt(bufferedReader.readLine());

        } catch (IOException exception) {
            System.err.println("error message : " + exception.getMessage());
        }
    }
}
