import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderSimpleGame extends LadderGame {
    private static final String PARTICIPANT_LINE = "|";
    private static final String MOVE_LINE = "-----";
    private static final String EMPTY_LINE = "     ";

    private List<List<Boolean>> bridge;
    private final Random randomInstance = new Random();
    private String[] participants;

    public void createBridge() {
        int row = this.getLadderHeight();
        int col = this.getNumberOfParticipants() - 1;
        this.bridge = createLadderMap(row, col);
    }

    public String getLadderString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(getParticipantsString());

        for (List<Boolean> floor : this.bridge) {
            stringBuilder.append(getFloorString(floor));
        }

        return stringBuilder.toString();
    }

    private String getParticipantsString() {
        // TODO: 참가자 5자 기준으로 String 값 리턴
        return "";
    }

    private List<Boolean> createNoneContinueTrueList(int col) {

        List<Boolean> map = new ArrayList<>();
        boolean previousColumnValue = false;

        for (int j = 0; j < col; j++) {
            // 연속된 다리가 나올 수 없음.
            boolean isBridge = (!previousColumnValue) && trueAndFalseGenerator();
            map.add(isBridge);

        }

        return map;
    }

    private List<List<Boolean>> createLadderMap(int row, int col) {

        List<List<Boolean>> ladderMap = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            List<Boolean> list = createNoneContinueTrueList(col);
            ladderMap.add(list);
        }

        return ladderMap;
    }

    private boolean trueAndFalseGenerator() {
        return randomInstance.nextBoolean();
    }

    private String getFloorString(List<Boolean> floor) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int col = 0; col < this.getNumberOfParticipants() * 2 - 1; col++) {
            stringBuilder.append(getBridgeChar(col, floor));
        }

        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

    private String getBridgeChar(int col, List<Boolean> floor) {
        if (col % 2 == 0) {
            return PARTICIPANT_LINE;
        } else if (floor.get(col / 2)) {
            return MOVE_LINE;
        }

        return EMPTY_LINE;

    }

    public void setParticipants(String[] participants) {
        this.participants = participants;
    }
}
