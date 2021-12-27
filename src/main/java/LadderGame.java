import java.util.Scanner;

public class LadderGame {
    static int numberOfGamers;
    static int heightOfLadder;

    public static void main(String[] args) {
        input();
        Ladder ladder = new Ladder(numberOfGamers, heightOfLadder);
        ladder.printLadder();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("참여할 사람은 몇 명인가요?");
        numberOfGamers = scanner.nextInt();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        heightOfLadder = scanner.nextInt();
    }
}


