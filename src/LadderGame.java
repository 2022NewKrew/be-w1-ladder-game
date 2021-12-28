import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LadderGame {

    public void startGame() {
        int person = readPerson();
        int height = readHeight();
        Ladder ladder = new Ladder(person, height);

        ladder.makeLadder();
        ladder.printLadder();
    }

    private int readPerson() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.println("참여할 사람은 몇 명인가요?");
                return Integer.parseInt(br.readLine());
            } catch (Exception e) {
                System.out.println("정확한 정수를 입력해주세요.");
            }
        }
    }

    private int readHeight() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.println("최대 사다리 높이는 몇 개인가요?");
                return Integer.parseInt(br.readLine());
            } catch (Exception e) {
                System.out.println("정확한 정수를 입력해주세요.");
            }
        }
    }
}
