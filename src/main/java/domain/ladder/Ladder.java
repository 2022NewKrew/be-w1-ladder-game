package domain.ladder;

import domain.gameResult.GameResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private static final int FRAME_MIN_LENGTH = 1;
    private static final int HEIGHT_MIN_LENGTH = 1;

    private final List<LadderFrameLine> lines;

    public Ladder(int frameLength, int height) {
        LadderPrecondition.checkFrameLength(frameLength, FRAME_MIN_LENGTH);
        LadderPrecondition.checkLadderHeight(height, HEIGHT_MIN_LENGTH);

        this.lines = generateLines(frameLength, height);
    }

    private List<LadderFrameLine> generateLines(int frameLength, int height) {
        return Stream
                .generate(() -> new LadderFrameLine(frameLength))
                .limit(height)
                .collect(Collectors.toList());
    }

    private List<Integer> getBridgeIndexes() {
        List<Integer> indexes = new ArrayList<>();
        for (LadderFrameLine line : lines) {
            indexes.addAll(line.getBridgeIndexes());
        }
        return Collections.unmodifiableList(indexes);
    }

    public GameResult getGameResult(List<String> users, List<String> results) {
        return GameResult.getGameResult(getBridgeIndexes(), users, results);
    }

    public List<LadderFrameLine> getLines() {
        return lines;
    }
}
