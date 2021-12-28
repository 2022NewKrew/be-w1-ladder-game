import input.Input;
import ladder.dto.Ladder;
import ladder.LadderBuilder;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Ladder ladder = inputLadderInfo();
        ladder.print();
    }

    public static Ladder inputLadderInfo() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        List<String> participants = Input.inputParticipantsName();
        System.out.println();

        System.out.println("최대 사다리 높이는 몇인가요?");
        int maxHeightOfLadder = Input.inputHeight();

        LadderBuilder ladderBuilder = new LadderBuilder();
        return ladderBuilder.createLadder(participants, maxHeightOfLadder);
    }
}
