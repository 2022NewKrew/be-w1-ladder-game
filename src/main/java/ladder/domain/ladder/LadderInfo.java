package ladder.domain.ladder;

import ladder.domain.exception.LadderException;

import static ladder.domain.exception.LadderException.ErrorCode.*;

public class LadderInfo {

    private final String[] participants;
    private final int height;

    public LadderInfo(String[] participants, int height) throws LadderException {
        validateLadderInfo(participants, height);
        this.participants = participants;
        this.height = height;
    }

    public String[] getParticipants() {
        return participants;
    }

    public int getHeight() {
        return height;
    }

    private void validateLadderInfo(String[] participants, int height) throws LadderException {

        if (height < 1) {
            throw new LadderException(INVALID_HEIGHT, height);
        }
        if (participants.length == 0) {
            throw new LadderException(EMPTY_PARTICIPANTS);
        }
        for (String participant : participants) {
            validateParticipantName(participant);
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
}
