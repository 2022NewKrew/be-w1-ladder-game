import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LadderUI {

    private static final Scanner scanner = new Scanner(System.in);
    private static final int MAX_LENGTH = 6;
    private static final String BLANK_SPACE = " ";


    public static List<String> getNamesOfPeople() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return Arrays.asList(scanner.nextLine().split(","));
    }

    public static int getHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    public static void printNamesAndLadder(List<String> namesOfPeople, Ladder ladder) {
        printNames(namesOfPeople);
        printLadder(ladder);
    }

    private static void printNames(List<String> namesOfPeople) {
        String nameLine = namesOfPeople.stream()
                .map(LadderUI::resizeName)
                .collect(Collectors.joining(""));
        System.out.println(nameLine);
    }

    private static String resizeName(String name) {
        int length = name.length();
        return getPrefIndent(length) + name + getPostIndent(length);
    }

    private static String getPrefIndent(int length) {
        int indentCnt = (int) Math.ceil((MAX_LENGTH - length) * 0.5);
        return BLANK_SPACE.repeat(indentCnt);
    }

    private static String getPostIndent(int length) {
        int indentCnt = (int) Math.floor((MAX_LENGTH - length) * 0.5);
        return BLANK_SPACE.repeat(indentCnt);
    }

    private static void printLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            String lineToStr = line.getPoints().stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining());

            System.out.println(lineToStr);
        }
    }
}
