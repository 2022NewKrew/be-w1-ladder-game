import ladder.Ladder;
import ladder.LadderBuilder;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Ladder ladder = inputLadderInfo();
        ladder.print();
    }

    public static Ladder inputLadderInfo() {
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.println("참여할 사람은 몇 명인가요?");
            int numOfParticipant = scanner.nextInt();
            System.out.println("최대 사다리 높이는 몇인가요?");
            int maxHeightOfLadder = scanner.nextInt();

            LadderBuilder ladderBuilder = new LadderBuilder();
            return ladderBuilder.createLadder(numOfParticipant, maxHeightOfLadder);
        }
    }
}
