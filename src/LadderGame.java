import java.io.IOException;
import java.util.Scanner;

public class LadderGame {
    private static LadderGameInfo ladderGameInfo;

    private static void setLadderGameInfo() {
        Scanner input = new Scanner(System.in);

        System.out.println("참여할 사람은 몇 명인가요?");
        int playerCnt = input.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int ladderHeight = input.nextInt();

        ladderGameInfo = new LadderGameInfo(playerCnt, ladderHeight);

        input.close();
    }

    public static void main(String[] args) throws IOException {
        setLadderGameInfo();
        ladderGameInfo.makeLadder();
        ladderGameInfo.drawLadder();
    }
}
