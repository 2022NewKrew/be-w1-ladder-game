import java.util.Scanner;

public class InputController {
    private final int noParticipants;
    private final int heights;
    private static final Scanner sc = new Scanner(System.in);

    public InputController() {
        try (Scanner sc = new Scanner(System.in)) {
            noParticipants = typeParticipants();
            heights = typeHeights();
        }
    }

    public int typeParticipants() {
        System.out.println("참여할 사람은 몇 명인가요?");
        return sc.nextInt();
    }

    public int typeHeights() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return sc.nextInt();
    }

    public int getNoParticipants() {
        return noParticipants;
    }

    public int getHeights() {
        return heights;
    }
}
