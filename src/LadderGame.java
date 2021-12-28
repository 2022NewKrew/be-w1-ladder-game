import java.io.InputStream;
import java.util.Scanner;

public class LadderGame {
    private int peopleCount;
    private int ladderHeight;

    LadderGame() {
    }

    void startGame() {
        inputLadderInfo();

        int ladderWidth = peopleCount * 2 - 1;
        Ladder ladder = new Ladder(ladderWidth, ladderHeight);

        ladder.makeLadderMap();
        ladder.printLadder();
    }

    private void inputLadderInfo() {
        InputStream inputStream = System.in;
        Scanner scan = new Scanner(inputStream);

        System.out.println("참여할 사람은 몇 명인가요?");
        this.peopleCount = scan.nextInt();

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        this.ladderHeight = scan.nextInt();
    }
}