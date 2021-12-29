package domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {


    private final List<LadderFrameLine> lines;

    public Ladder(int frameLength, int height) {
        checkNumberOfPerson(frameLength);
        checkLadderHeight(height);
        this.lines = generateLines(frameLength - 1, height);
    }

    private List<LadderFrameLine> generateLines(int frameLength, int height) {
        List<LadderFrameLine> generatedLines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            generatedLines.add(new LadderFrameLine(frameLength));
        }
        return Collections.unmodifiableList(generatedLines);
    }

    private void checkNumberOfPerson(int frameLength) {
        if (frameLength < 1) {
            throw new IllegalArgumentException("참여하는 사람의 수는 양의 정수여야 합니다.");
        }
    }

    private void checkLadderHeight(int height) {
        if (height < 1) {
            throw new IllegalArgumentException("사다리의 높이는 양의 정수여야 합니다.");
        }
    }

    public List<LadderFrameLine> getLines() {
        return lines;
    }
}
