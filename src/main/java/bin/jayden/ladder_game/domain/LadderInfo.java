package bin.jayden.ladder_game.domain;

import bin.jayden.ladder_game.exception.InvalidLadderHeightException;
import bin.jayden.ladder_game.exception.InvalidNameSizeException;
import bin.jayden.ladder_game.exception.InvalidParticipantsSizeException;

import java.util.Collections;
import java.util.List;

public class LadderInfo {
    private final int height;
    private final List<String> participants;

    public LadderInfo(List<String> participants, int height) throws Exception {
        validation(participants, height);
        this.participants = Collections.unmodifiableList(participants);
        this.height = height;
    }

    public LadderInfo(String[] participants, int height) throws Exception {
        this(List.of(participants), height);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return participants.size();
    }

    public List<String> getParticipants() {
        return participants;
    }

    private void validation(List<String> participants, int height) throws Exception {
        participantsValidationCheck(participants);
        ladderHeightValidationCheck(height);
    }

    private static void participantsValidationCheck(List<String> participants) throws Exception {
        if (participants.size() < Constants.MIN_PARTICIPANT_SIZE || participants.size() > Constants.MAX_PARTICIPANT_SIZE)
            throw new InvalidParticipantsSizeException();

        for (String participant : participants)
            checkParticipantNameSize(participant);
    }

    private static void checkParticipantNameSize(String participant) throws InvalidNameSizeException {
        if (participant.length() < Constants.MIN_NAME_SIZE || participant.length() > Constants.MAX_NAME_SIZE)
            throw new InvalidNameSizeException();
    }

    private static void ladderHeightValidationCheck(int height) throws InvalidLadderHeightException {
        if (height < Constants.MIN_LADDER_HEIGHT || height > Constants.MAX_LADDER_HEIGHT)
            throw new InvalidLadderHeightException();
    }

}
