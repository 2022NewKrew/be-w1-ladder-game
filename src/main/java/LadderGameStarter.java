import java.util.Scanner;

public class LadderGameStarter {
    Scanner sc = new Scanner(System.in);

    public int getNumOfPeople() {
        System.out.println("참여할 사람은 몇 명인가요?");
        return sc.nextInt();
    }

    public int getHeightOfLadder() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return sc.nextInt();
    }
}
