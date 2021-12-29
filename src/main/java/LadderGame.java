import TypeScanner.PositiveIntScanner;
import TypeScanner.StringArrayScanner;

public class LadderGame {
    private static final int MAX_NAME_LENGTH = 5;

    public static void main(String[] args) {
        String[] participants = getParticipantsFromCli();
        int maxLadderHeight = getMaxLadderHeightFromCli();
        Ladder ladder = new Ladder(participants, maxLadderHeight);
        LadderRenderer renderer = new LadderRenderer();
        renderer.setMaxLength(MAX_NAME_LENGTH);
        renderer.render(ladder);
    }

    private static String[] getParticipantsFromCli() {
        StringArrayScanner scanner = new StringArrayScanner();
        scanner.setMaxLength(MAX_NAME_LENGTH);
        return scanner.getValueWithQuestion("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    private static int getMaxLadderHeightFromCli() {
        PositiveIntScanner scanner = new PositiveIntScanner();
        return scanner.getValueWithQuestion("최대 사다리 높이는 몇 개인가요?");
    }
}
