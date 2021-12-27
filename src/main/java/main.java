import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {

    public static void main(String[] args) {
        try {

            Ladder ladder = input();
            LadderGame ladderGame = new LadderGameStep1();

            ladder.setBridge(ladderGame.createMap(ladder));

            String output = ladder.getLadderString();
            System.out.println(output);

        } catch (Exception e) {
            System.err.println("입출력 에러 : " + e.getMessage());
        }
    }

    private static Ladder input() throws IOException {
        Ladder ladder = new Ladder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("참여할 사람은 몇명인가요?");
        ladder.setNumberOfParticipants(Integer.parseInt(bufferedReader.readLine()));

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        ladder.setLadderHeight(Integer.parseInt(bufferedReader.readLine()));

        return ladder;
    }
}
