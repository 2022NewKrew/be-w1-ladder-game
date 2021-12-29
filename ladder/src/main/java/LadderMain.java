import java.util.List;

public class LadderMain {
    public static void main(String[] args){
        List<Participant> participants =
                ParticipantScanner.getParticipants("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)", 5);
        int numOfLadderHeight = PositiveIntScanner.getPositiveInt("최대 사다리 높이는 몇 개인가요?");

        Ladder ladder = new Ladder(participants, numOfLadderHeight);
        LadderPrinter.print(ladder);
    }
}
