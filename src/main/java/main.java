import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {

    public static void main(String[] args) {
        try {
            LadderSimpleGame ladderSimpleGame = new LadderSimpleGame(new LadderGameServiceImpl());
            input(ladderSimpleGame);

            ladderSimpleGame.createBridge();

            String output = ladderSimpleGame.getLadderString();
            System.out.println(output);

        } catch (Exception e) {
            System.err.println("입출력 에러 : " + e.getMessage());
        }
    }

    private static void input(LadderSimpleGame ladderSimpleGame) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("참여할 사람은 몇명인가요?");
        ladderSimpleGame.setNumberOfParticipants(Integer.parseInt(bufferedReader.readLine()));

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        ladderSimpleGame.setLadderHeight(Integer.parseInt(bufferedReader.readLine()));
    }
}
