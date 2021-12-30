package ladder.domain.ladder;

import ladder.domain.exception.LadderException;

import static ladder.domain.exception.LadderException.ErrorCode.*;

public class LadderInfo {

    private final String[] participants;
    private final String[] results;
    private final int height;

    public LadderInfo(String[] participants, String[] results, int height) throws LadderException {
        validateLadderInfo(participants, results, height);
        this.participants = participants;
        this.results = results;
        this.height = height;
    }

    public String[] getParticipants() {
        return participants;
    }

    public int getHeight() {
        return height;
    }

    private void validateLadderInfo(String[] participants, String[] results, int height) throws LadderException {
        if (height < 1) {
            throw new LadderException(INVALID_HEIGHT, height);
        }
        if (participants.length == 0) {
            throw new LadderException(EMPTY_PARTICIPANTS);
        }
        if (participants.length != results.length) {
            throw new LadderException(MISMATCH_PARTICIPANTS_AND_RESULT);
        }
        for (int i = 0; i < participants.length; i++) {
            validateParticipantName(participants[i]);
            validateResultName(results[i]);
        }
    }

    private void validateParticipantName(String participant) throws LadderException {
        if (participant.length() == 0) {
            throw new LadderException(EMPTY_PARTICIPANT_NAME);
        }
        if (participant.length() > 5) {
            throw new LadderException(EXCEED_MAX_PARTICIPANT_NAME, participant);
        }
    }

    private void validateResultName(String result) throws LadderException {
        if (result.length() == 0) {
            throw new LadderException(EMPTY_RESULT_NAME);
        }
        if (result.length() > 5) {
            throw new LadderException(EXCEED_MAX_RESULT_NAME);
        }
    }
}
