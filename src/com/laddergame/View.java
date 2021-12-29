package com.laddergame;

import java.util.List;
import java.util.Scanner;

public class View {
    static Scanner scanner = new Scanner(System.in);

    private enum DELIMITER {
        LADDER("-----"),
        NO_LADDER("     "),
        VERTICAL_LINE("|"),
        LADDER_PADDING("    ")
        ;

        DELIMITER(String delimiter) {
            this.value = delimiter;
        }

        private final String value;
    }

    static public String inputParticipantName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }

    static public int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇인가요?");
        return scanner.nextInt();
    }

    static public void outputParticipantNames(List<String> names) {
        names.forEach(name -> System.out.printf("%6s", name));
        System.out.println();
    }

    static public void outputLadderGameResult(List<List<Boolean>> result) {
        result.forEach(View::outputRoundResult);
    }

    static private void outputRoundResult(List<Boolean> roundResult) {
        System.out.print(DELIMITER.LADDER_PADDING.value);
        roundResult.forEach(hasLadder -> {
            System.out.print(DELIMITER.VERTICAL_LINE.value);
            String ladder = hasLadder ? DELIMITER.LADDER.value : DELIMITER.NO_LADDER.value;
            System.out.print(ladder);
        });
        System.out.println(DELIMITER.VERTICAL_LINE.value);
    }
}
