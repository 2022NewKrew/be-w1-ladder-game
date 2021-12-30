package keith.io;

import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import keith.domain.Ladder;

public class InputManager {
    public Ladder getLadderInput(Scanner scanner) {
        List<String> participants, destinations;
        int height;

        participants = getStringInput(scanner, "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        destinations = getStringInput(scanner, "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        checkValidDest(destinations, participants);

        height = getHeightInput(scanner);

        return new Ladder(participants, destinations, height);
    }

    public String getResultInput(Scanner scanner) {
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }

    private List<String> getStringInput(Scanner scanner, String message) {
        System.out.println(message);
        List<String> input = Arrays.asList(scanner.nextLine().split(","));
        checkValidStrings(input);
        return input;
    }

    private int getHeightInput(Scanner scanner) {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = Integer.parseInt(scanner.nextLine());
        checkHeight(height);
        return height;
    }

    private static void checkValidStrings(List<String> participants) {
        if (participants.size() < 1) {
            throw new IllegalArgumentException("입력값이 1개 이상이어야 합니다!");
        }

        for (String name : participants) {
            checkValidString(name);
        }
    }

    private static void checkValidString(String name) {
        if (name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("공백인 입력값이 존재합니다!");
        }
    }

    private static void checkValidDest(List<String> destinations, List<String> participants) {
        if (destinations.size() != participants.size()) {
            throw new IllegalArgumentException("사람 수와 결과 수가 다릅니다!");
        }
    }

    private static void checkHeight(int height) {
        if (height < 1) {
            throw new IllegalArgumentException("사다리 높이는 1개 이상이어야 합니다!");
        }
    }
}
