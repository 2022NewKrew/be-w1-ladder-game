package ladder;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LadderMain {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        List<String> persons = inputPersons();
        int ladderHeight = inputLadderHeight();

        Ladder ladder = new Ladder(persons, ladderHeight);
        ladder.makeLadder();

        System.out.println(ladder);
    }

    // 사다리 높이를 입력받는 메서드, 양의 정수만을 입력받도록 처리하는 것이 필요할 것 같다.
    private static int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return sc.nextInt();
    }

    // 참여하는 사람들의 이름을 입력받는 메서드, 인원이 최소 2명이며 각 이름을 5자 이내로 입력받도록 처리하는 것이 필요할 것 같다.
    private static List<String> inputPersons() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String inputText = sc.nextLine();

        return Arrays.asList(inputText.split(","));
    }
}
