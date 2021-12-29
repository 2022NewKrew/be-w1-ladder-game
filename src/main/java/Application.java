import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Application {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void runApp() {
        List<Participant> participants = initializeParticipants();
        Ladder ladder = initializeLadder(participants.size());

        ladder.makeRandomLadder();
        ladder.printLadder();
    }

    public static List<Participant> initializeParticipants() {
        String[] nameOfParticipants = inputParticipants();

        return Arrays.stream(nameOfParticipants).map(name -> new Participant(name)).collect(Collectors.toList());
    }

    public static Ladder initializeLadder(int numOfPeople) {
        int heightOfLadder = inputHeight();
        Ladder ladder = new Ladder(heightOfLadder, numOfPeople);

        return ladder;
    }

    public static int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        return Integer.parseInt(SCANNER.nextLine());
    }

    public static String[] inputParticipants() {
        System.out.println("참여할 사람 이름을 입력하세요.");
        String inputOfParticipants = SCANNER.nextLine();

        return inputOfParticipants.split(" ");
    }

    public static void main(String[] args) {
        runApp();
    }
}
