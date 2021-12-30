package ladder.domain.ladder;

import java.util.HashMap;
import java.util.Map;

public class LadderResult {

    private final Map<String, String> resultMap;

    public LadderResult(Ladder ladder) {
        this.resultMap = process(ladder);
    }

    private Map<String, String> process(Ladder ladder) {
        Map<String, String> resultMap = new HashMap<>();
        String[] participants = ladder.getParticipants();

        for (int currentParticipant = 0; currentParticipant < participants.length; currentParticipant++) {
            String result = findResult(ladder, currentParticipant, 0, ladder.getResults(), false);
            resultMap.put(participants[currentParticipant], result);
        }
        return resultMap;
    }

    private String findResult(Ladder ladder, int currentPosition, int currentHeight, String[] results, boolean passed) {
        if (currentHeight == ladder.getHeight()) {
            return results[currentPosition];
        }

        if (currentPosition == 0) {
            return leftSide(ladder, currentPosition, currentHeight, results, passed);
        } else if (currentPosition == ladder.getParticipants().length - 1) {
            return rightSide(ladder, currentPosition, currentHeight, results, passed);
        }
        return middleSide(ladder, currentPosition, currentHeight, results, passed);
    }

    private String leftSide(Ladder ladder, int currentPosition, int currentHeight, String[] results, boolean passed) {
        if (ladder.isConnected(currentPosition, currentHeight) && !passed) {
            return moveRight(ladder, currentPosition, currentHeight, results);
        }
        return moveDown(ladder, currentPosition, currentHeight, results);
    }

    private String rightSide(Ladder ladder, int currentPosition, int currentHeight, String[] results, boolean passed) {
        if (ladder.isConnected(currentPosition - 1, currentHeight) && !passed) {
            return moveLeft(ladder, currentPosition, currentHeight, results);
        }
        return moveDown(ladder, currentPosition, currentHeight, results);
    }

    private String middleSide(Ladder ladder, int currentPosition, int currentHeight, String[] results, boolean passed) {
        if (ladder.isConnected(currentPosition - 1, currentHeight) && !passed) {
            return moveLeft(ladder, currentPosition, currentHeight, results);
        } else if (ladder.isConnected(currentPosition, currentHeight) && !passed) {
            return moveRight(ladder, currentPosition, currentHeight, results);
        }
        return moveDown(ladder, currentPosition, currentHeight, results);
    }

    private String moveLeft(Ladder ladder, int currentPosition, int currentHeight, String[] results) {
        return findResult(ladder, currentPosition - 1, currentHeight, results, true);
    }

    private String moveRight(Ladder ladder, int currentPosition, int currentHeight, String[] results) {
        return findResult(ladder, currentPosition + 1, currentHeight, results, true);
    }

    private String moveDown(Ladder ladder, int currentPosition, int currentHeight, String[] results) {
        return findResult(ladder, currentPosition, currentHeight + 1, results, false);
    }

    public String getAllResult() {
        StringBuilder sb = new StringBuilder();

        resultMap.forEach((k, v) ->
                sb.append(String.format("%s : %s\n", k, v))
        );
        return sb.toString();
    }

    public String getOneResult(String participant) {
        return resultMap.get(participant);
    }
}
