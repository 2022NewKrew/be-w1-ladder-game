package ladder.domain;

import ladder.exception.InvalidBridgeException;
import ladder.exception.OutOfInputStringException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderSimpleGame extends LadderGame {

    private final int MAX_INPUT_PARTICIPANT_NAME_LENGTH = 5;

    private final Random randomInstance = new Random();

    public void createBridge() {
        int row = this.getLadderHeight();
        int col = this.getNumberOfParticipants() - 1;
        this.setBridge(createLadderMap(row, col));
        checkInvalidBridge();
    }

    private List<Boolean> createNoneContinueTrueList(int col) {

        List<Boolean> map = new ArrayList<>();
        boolean previousColumnValue = false;

        for (int i = 0; i < col; i++) {
            boolean isBridge = (!previousColumnValue) && trueAndFalseGenerator();
            map.add(isBridge);
            previousColumnValue = isBridge;
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

    public void checkInvalidBridge() {
        for (List<Boolean> list : this.getBridge()) {
            checkInvalidContinueTrueList(list);
        }
    }

    private void checkInvalidContinueTrueList(List<Boolean> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) && list.get(i + 1)) throw new InvalidBridgeException("연속된 다리는 생성할 수 없습니다.");
        }
    }

    public void checkInvalidNameLength() {
        for (String participant : this.getParticipants()) {
            if (participant.length() > MAX_INPUT_PARTICIPANT_NAME_LENGTH) {
                throw new OutOfInputStringException("참가자 수의 이름은 최대 5개 입니다.");
            }
        }
    }
}
