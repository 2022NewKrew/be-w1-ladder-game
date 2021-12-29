import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LadderGame {
    private static final int MIN_SIZE_OF_PARTICIPANT = 2;
    private static final Scanner SCANNER = new Scanner(System.in);
    private List<Participant> participants;
    private Ladder ladder;

    /**
     * 사다리 게임을 시작한다.
     * - 사다리 게임에 참여할 사람 이름과 사다리의 높이를 입력받는다.
     */
    public void start() throws Exception {
        this.participants = inputParticipants();
        this.ladder = new Ladder(this.participants.size() - 1, inputLadderHeight());
    }

    /**
     * 사다리 게임에 참여할 사람 이름 입력 받기
     */
    private List<Participant> inputParticipants() throws Exception {
        List<String> names = inputNamesByComma();
        validateSizeOfParticipants(names.size());

        List<Participant> participants = new ArrayList<>();
        for (String name : names) {
            validateParticipantName(name);
            participants.add(new Participant(name));
        }
        return participants;
    }

    /**
     * 콤마(,)로 구분된 이름 입력 받기 (공백 무시)
     */
    private List<String> inputNamesByComma() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return Arrays.stream(SCANNER.nextLine().split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    /**
     * 참가자 인원 수 유효성 검사
     */
    private void validateSizeOfParticipants(int size) throws Exception {
        if (size < MIN_SIZE_OF_PARTICIPANT) {
            throw new Exception(MIN_SIZE_OF_PARTICIPANT + "명 이상을 입력하세요.");
        }
    }

    /**
     * 참가자 이름 유효성 검사
     */
    private void validateParticipantName(String name) throws Exception {
        if (name == null || name.length() == 0 || name.length() > Participant.MAX_LENGTH_OF_PARTICIPANT_NAME) {
            throw new Exception("사람 이름은 공백이거나 " + Participant.MAX_LENGTH_OF_PARTICIPANT_NAME + "글자을 초과하여 입력할 수 없습니다.");
        }
    }

    /**
     * 사다리 높이 입력 받기
     */
    private int inputLadderHeight() throws Exception {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return inputPositiveNumber();
    }

    /**
     * 양수 입력 받기
     */
    private int inputPositiveNumber() throws Exception {
        int number = 0;
        try {
            number = SCANNER.nextInt();
        } catch (Exception e) {
            throw new Exception("잘못된 입력 값입니다.");
        }
        if (number <= 0) {
            throw new Exception("0과 같거나 작은 수를 입력하였습니다.");
        }
        return number;
    }

    /**
     * 참가자 이름과 사다리 상태를 출력한다.
     */
    public void printParticipantsAndLadder() {
        this.printParticipants();
        this.printLadder();
    }

    /**
     * 전체 참가자 이름을 출력한다.
     */
    private void printParticipants() {
        System.out.println(participants.stream()
                .map(Participant::getNameCenterAligned)
                .collect(Collectors.joining()));
    }

    /**
     * 사다리 상태를 출력한다.
     */
    private void printLadder() {
        System.out.println(ladder.toString());
    }

}
