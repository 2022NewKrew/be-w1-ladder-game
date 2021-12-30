import java.util.Scanner;

public class LadderInfo {
    private final int numOfPeople;
    private final int heightOfLadder;

    public LadderInfo() {
        Scanner sc = new Scanner(System.in);

        System.out.println("참여할 사람은 몇 명인가요?");
        numOfPeople = sc.nextInt();

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        heightOfLadder = sc.nextInt();
    }

    public int getNumOfPeople() {
        return numOfPeople;
    }
    public int getHeightOfLadder() {
        return heightOfLadder;
    }
}
