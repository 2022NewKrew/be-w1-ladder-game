package ladder.domain.ladder;

import ladder.config.LadderGameConfig;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderResult {

    private final Map<String, String> resultMap;

    public LadderResult(Ladder ladder) {
        this.resultMap = process(ladder);
    }

    private Map<String, String> process(Ladder ladder) {
        Map<String, String> resultMap = new HashMap<>();
        List<String> participants = ladder.getParticipants();

        for (int currentParticipant = 0; currentParticipant < participants.size(); currentParticipant++) {
            String result = startLadderFlow(ladder, currentParticipant);
            resultMap.put(participants.get(currentParticipant), result);
        }
        return resultMap;
    }

    private String startLadderFlow(Ladder ladder, int currentParticipant) {
        return ladderFlow(ladder, currentParticipant, 0, false);
    }

    private String ladderFlow(Ladder ladder, int currentPosition, int currentHeight, boolean isPassed) {
        if (currentHeight == ladder.getHeight()) {
            return ladder.getResults().get(currentPosition);
        }
        if (currentPosition == 0) {
            return leftSide(ladder, currentPosition, currentHeight, isPassed);
        }
        if (currentPosition == ladder.getNumOfParticipants() - 1) {
            return rightSide(ladder, currentPosition, currentHeight, isPassed);
        }
        return middleSide(ladder, currentPosition, currentHeight, isPassed);
    }

    private String leftSide(Ladder ladder, int currentPosition, int currentHeight, boolean passed) {
        if (ladder.isConnected(currentPosition, currentHeight) && !passed) {
            return moveRight(ladder, currentPosition, currentHeight);
        }
        return moveDown(ladder, currentPosition, currentHeight);
    }

    private String rightSide(Ladder ladder, int currentPosition, int currentHeight, boolean passed) {
        if (ladder.isConnected(currentPosition - 1, currentHeight) && !passed) {
            return moveLeft(ladder, currentPosition, currentHeight);
        }
        return moveDown(ladder, currentPosition, currentHeight);
    }

    private String middleSide(Ladder ladder, int currentPosition, int currentHeight, boolean passed) {
        if (ladder.isConnected(currentPosition - 1, currentHeight) && !passed) {
            return moveLeft(ladder, currentPosition, currentHeight);
        }
        if (ladder.isConnected(currentPosition, currentHeight) && !passed) {
            return moveRight(ladder, currentPosition, currentHeight);
        }
        return moveDown(ladder, currentPosition, currentHeight);
    }

    private String moveLeft(Ladder ladder, int currentPosition, int currentHeight) {
        return ladderFlow(ladder, currentPosition - 1, currentHeight, true);
    }

    private String moveRight(Ladder ladder, int currentPosition, int currentHeight) {
        return ladderFlow(ladder, currentPosition + 1, currentHeight, true);
    }

    private String moveDown(Ladder ladder, int currentPosition, int currentHeight) {
        return ladderFlow(ladder, currentPosition, currentHeight + 1, false);
    }

    public String getAllResult() {
        StringBuilder sb = new StringBuilder();

        resultMap.forEach((participant, result) -> {
                    sb.append(participant);
                    sb.append(" : ");
                    sb.append(result);
                    sb.append(LadderGameConfig.NEW_LINE);
                }
        );
        return sb.toString();
    }

    public String getOneResult(String participant) {
        return resultMap.get(participant);
    }
}
