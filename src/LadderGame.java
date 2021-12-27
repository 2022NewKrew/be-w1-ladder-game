import java.util.Scanner;


public class LadderGame {
    public static void main(String[] args) {
        // 1. Prompt and read input(number of players, ladder height)
        Scanner scanner = new Scanner(System.in);

        System.out.println("참여할 사람은 몇 명인가요?");
        int numOfPlayers = scanner.nextInt();

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int heightOfLadder = scanner.nextInt();


        // 2. Generate ladder
        Ladder ladder = new Ladder(numOfPlayers, heightOfLadder);
        ladder.generateSimpleRandom();


        // 3. Show result
        System.out.println("\n" + ladder);
    }
}
