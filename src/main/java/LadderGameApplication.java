import java.util.Scanner;

public class LadderGameApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LadderGame ladderGame = new LadderGame();

        System.out.println("참여할 사람은 몇 명인가요?");
        int numberOfPerson = scanner.nextInt();

        System.out.println("최대 사다리 높이는 몇인가요?");
        int heightOfLadder = scanner.nextInt();

        ladderGame.run(numberOfPerson, heightOfLadder);
    }
}
