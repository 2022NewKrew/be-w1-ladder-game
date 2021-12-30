package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Participant;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LadderGameView {
    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * 사다리 게임에 참여할 사람 이름 입력 받기
     * - 콤마(,)로 구분된 이름 입력 받기 (공백 무시)
     */
    public static List<String> inputParticipantNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return Arrays.stream(SCANNER.nextLine().split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    /**
     * 사다리 높이 입력 받기
     */
    public static int inputLadderHeight() throws Exception {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        try {
            return SCANNER.nextInt();
        } catch (Exception e) {
            throw new Exception("잘못된 입력 값입니다.");
        }
    }

    /**
     * 참가자 이름과 사다리 상태를 출력한다.
     */
    public static void printParticipantsAndLadder(List<Participant> participants, Ladder ladder) {
        printParticipants(participants);
        printLadder(ladder);
    }

    /**
     * 전체 참가자 이름을 출력한다.
     */
    private static void printParticipants(List<Participant> participants) {
        System.out.println(participants.stream()
                .map(Participant::getNameCenterAligned)
                .collect(Collectors.joining(" ")));
    }

    /**
     * 사다리 상태를 출력한다.
     */
    private static void printLadder(Ladder ladder) {
        System.out.println(ladder.toString());
    }

}
