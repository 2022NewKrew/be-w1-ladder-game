package ladder.domain.ladder;

import ladder.config.LadderGameConfig;
import ladder.exception.LadderException;

import java.util.List;

import static ladder.exception.LadderException.ErrorCode.*;

public class LadderInfo {

    private final List<String> participants;
    private final List<String> results;
    private final int height;

    public LadderInfo(List<String> participants, List<String> results, int height) throws LadderException {
        validateLadderInfo(participants, results, height);
        this.participants = participants;
        this.results = results;
        this.height = height;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public List<String> getResults() {
        return results;
    }

    public int getHeight() {
        return height;
    }

    private void validateLadderInfo(List<String> participants, List<String> results, int height) throws LadderException {
        if (height < 1) {
            throw new LadderException(INVALID_HEIGHT, height);
        }
        if (participants.size() == 0) {
            throw new LadderException(EMPTY_PARTICIPANTS);
        }
        if (participants.size() != results.size()) {
            throw new LadderException(MISMATCH_PARTICIPANTS_AND_RESULT);
        }
        for (int i = 0; i < participants.size(); i++) {
            validateParticipantName(participants.get(i));
            validateResultName(results.get(i));
        }
    }

    private void validateParticipantName(String participant) throws LadderException {
        if (participant.length() == 0) {
            throw new LadderException(EMPTY_PARTICIPANT_NAME);
        }
        if (participant.length() > LadderGameConfig.MAX_INPUT_LENGTH) {
            throw new LadderException(EXCEED_MAX_PARTICIPANT_NAME, participant);
        }
    }

    private void validateResultName(String result) throws LadderException {
        if (result.length() == 0) {
            throw new LadderException(EMPTY_RESULT_NAME);
        }
        if (result.length() > LadderGameConfig.MAX_INPUT_LENGTH) {
            throw new LadderException(EXCEED_MAX_RESULT_NAME);
        }
    }
}
