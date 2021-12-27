import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int numOfPlayer = getInputInt("참여할 사람은 몇 명인가요?");
        int ladderHeight = getInputInt("최대 사다리 높이는 몇 개인가요?");

        new LadderGame(numOfPlayer, ladderHeight).start();
    }

    private static int getInputInt(String msg) {
        System.out.println(msg);
        return sc.nextInt();
    }
}
