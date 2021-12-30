import java.util.Scanner;

public class Application {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void runApp() {
        try {
            String[] names = inputParticipants();
            validateParticipants(names);

            int height = inputHeight();

            LadderGame ladderGame = new LadderGame(names, height);
            ladderGame.printInformation();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
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

    public static void validateParticipants(String[] names) {
        if (names.length <= 1) {
            throw new RuntimeException("참여자의 수는 2명 이상이여야 합니다.");
        }

        for (int i = 0; i < names.length; i++) {
            if (names[i].length() >= 6) {
                throw new RuntimeException("참여자의 이름 길이는 5자 이하여야 합니다.");
            }
        }
    }

    public static void main(String[] args) {
        runApp();
    }
}
