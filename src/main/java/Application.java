import java.util.Scanner;

public class Application {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void runApp() {
        String[] names = inputParticipants();
        int height = inputHeight();

        LadderGame ladderGame = new LadderGame(names, height);
        ladderGame.printInformation();
    }

    public static int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");

        return Integer.parseInt(SCANNER.nextLine());
    }

    public static String[] inputParticipants() {
        System.out.println("참여할 사람 이름을 입력하세요.");
        String inputOfParticipants = SCANNER.nextLine();

        return inputOfParticipants.split(",");
    }

    public static void main(String[] args) {
        runApp();
    }
}
