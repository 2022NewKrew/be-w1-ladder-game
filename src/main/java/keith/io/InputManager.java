package keith.io;

import keith.domain.Ladder;

import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

public class InputManager {
    public Ladder getLadderInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            List<String> participantsList = getParticipantInput(scanner);
            checkValidNames(participantsList);

            int height = getHeightInput(scanner);
            checkHeight(height);

            return new Ladder(participantsList, height);
        }
    }

    private List<String> getParticipantInput(Scanner scanner) {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        List<String> input = Arrays.asList(scanner.next().split(","));
        return input;
    }

    private int getHeightInput(Scanner scanner) {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    private static void checkValidNames(List<String> participantsList) {
        if (participantsList.size() < 1) {
            throw new IllegalArgumentException("사람은 1명 이상이어야 합니다!");
        }

        for (String name : participantsList) {
            checkValidName(name);
        }
    }

    private static void checkValidName(String name) {
        if (name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("공백인 사람 이름이 존재합니다!");
        }
    }

    private static void checkHeight(int height) {
        if (height < 1) {
            throw new IllegalArgumentException("사다리 높이는 1개 이상이어야 합니다!");
        }
    }
}
