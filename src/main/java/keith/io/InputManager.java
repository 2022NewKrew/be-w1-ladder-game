package keith.io;

import keith.Main;
import keith.domain.Ladder;

import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

public class InputManager {
    public Ladder getInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
            List<String> participantsList = Arrays.asList(scanner.next().split(","));
            checkValidNames(participantsList);
            cutLongNames(participantsList);

            System.out.println("최대 사다리 높이는 몇 개인가요?");
            int height = scanner.nextInt();
            checkHeight(height);

            return new Ladder(participantsList, height);
        }
    }

    private static void checkValidNames(List<String> participantsList) {
        if (participantsList.size() < 1) {
            throw new IllegalArgumentException("사람은 1명 이상이어야 합니다!");
        }

        for (int i = 0; i < participantsList.size(); i++) {
            String name = participantsList.get(i);
            checkValidName(name);
            // 이름이 5글자 이상이면 5글자까지 자르기
            participantsList.set(i, name.substring(0, Math.min(Main.MAX_NAME_LEN, name.length())));
        }
    }

    private static void checkValidName(String name) {
        if (name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("공백인 사람 이름이 존재합니다!");
        }
    }

    private static void cutLongNames(List<String> participantsList) {
        for (int i = 0; i < participantsList.size(); i++) {
            String name = participantsList.get(i);
            // 이름이 5글자 이상이면 5글자까지 자르기
            participantsList.set(i, name.substring(0, Math.min(Main.MAX_NAME_LEN, name.length())));
        }
    }

    private static void checkHeight(int height) {
        if (height < 1) {
            throw new IllegalArgumentException("사다리 높이는 1개 이상이어야 합니다!");
        }
    }
}
