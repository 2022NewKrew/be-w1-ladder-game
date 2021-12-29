package keith.io;

import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

public class InputManager {
    public int height;
    public String participants;
    public List<String> participantsList;

    public void getInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
            this.participants = scanner.next();
            this.participantsList = Arrays.asList(this.participants.split(","));
            checkParticipants(this.participantsList);

            System.out.println("최대 사다리 높이는 몇 개인가요?");
            this.height = scanner.nextInt();
            checkHeight(this.height);
        }
    }

    public int getHeight() {
        return this.height;
    }

    public List<String> getParticipants() {
        return this.participantsList;
    }

    private static void checkParticipants(List<String> participantsList) {
        if (participantsList.size() < 1) {
            throw new IllegalArgumentException("사람은 1명 이상이어야 합니다!");
        }

        for (int i = 0; i < participantsList.size(); i++) {
            String name = participantsList.get(i);
            checkValidName(name);
            // 이름이 5글자 이상이면 5글자까지 자르기
            participantsList.set(i, name.substring(0, Math.min(5, name.length())));
        }
    }

    private static void checkValidName(String name) {
        if (name.length() < 1) {
            throw new IllegalArgumentException("사람 이름에 공백이 존재합니다!");
        }
    }

    private static void checkHeight(int height) {
        if (height < 1) {
            throw new IllegalArgumentException("사다리 높이는 1개 이상이어야 합니다!");
        }
    }
}
