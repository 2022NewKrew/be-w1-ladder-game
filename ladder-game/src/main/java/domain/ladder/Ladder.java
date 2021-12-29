package domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {


    private final List<LadderFrameLine> ladderFrameLineList;

    public Ladder(int numberOfPerson, int ladderHeight) throws IllegalArgumentException {
        checkNumberOfPerson(numberOfPerson);
        checkLadderHeight(ladderHeight);
        this.ladderFrameLineList = generateLadderFrameLineList(numberOfPerson - 1, ladderHeight);
    }

    private List<LadderFrameLine> generateLadderFrameLineList(int ladderFrameLength, int ladderHeight){
        List<LadderFrameLine> ladderFrameLineList = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            ladderFrameLineList.add(new LadderFrameLine(ladderFrameLength));
        }
        return Collections.unmodifiableList(ladderFrameLineList);
    }

    private void checkNumberOfPerson(int numberOfPerson) throws IllegalArgumentException {
        if (numberOfPerson < 1) {
            throw new IllegalArgumentException("참여하는 사람의 수는 양의 정수여야 합니다.");
        }
    }

    private void checkLadderHeight(int ladderHeight) throws IllegalArgumentException {
        if (ladderHeight < 1) {
            throw new IllegalArgumentException("사다리의 높이는 양의 정수여야 합니다.");
        }
    }

    public List<LadderFrameLine> getLadderFrameLineList() {
        return ladderFrameLineList;
    }
}
