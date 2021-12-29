import java.util.Scanner;
import java.util.stream.Collectors;

public class LadderUI {

    private static Scanner scanner = new Scanner(System.in);

    public static int getNumOfPeople() {
        System.out.println("참여할 사람은 몇 명인가요?");
        return scanner.nextInt();
    }

    public static int getHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    public static void printLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            String lineToStr = line.getPoints().stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining());

            System.out.println(lineToStr);
        }
    }
}
