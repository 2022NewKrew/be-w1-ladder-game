import java.util.Scanner;

public class LadderGame {

    private static LadderGenerator ladderGenerator = new NormalLadderGenerator();

    public static void main(String[] args) {
        int participants, heights;
        try(Scanner sc = new Scanner(System.in)){
            participants = getParticipants(sc);
            heights = getHeights(sc);
        }
        Ladder ladder = ladderGenerator.buildLadder(participants, heights);
        System.out.println(ladder);
    }

    public static int getParticipants(Scanner sc){
        System.out.println("참여할 사람은 몇 명인가요?");
        return sc.nextInt();
    }

    public static int getHeights(Scanner sc){
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return sc.nextInt();
    }

}
