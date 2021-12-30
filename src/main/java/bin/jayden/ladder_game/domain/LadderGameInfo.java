package bin.jayden.ladder_game.domain;

import bin.jayden.ladder_game.exception.InvalidLadderHeightException;
import bin.jayden.ladder_game.exception.InvalidNameSizeException;
import bin.jayden.ladder_game.exception.InvalidParticipantsSizeException;
import bin.jayden.ladder_game.exception.InvalidResultSizeException;

import java.util.Collections;
import java.util.List;

public class LadderGameInfo {
    private final List<String> participants;
    private final List<String> results;
    private final int height;

    public LadderGameInfo(List<String> participants, List<String> results, int height) throws Exception {
        this.participants = Collections.unmodifiableList(participants);
        this.results = Collections.unmodifiableList(results);
        this.height = height;
        validation();
    }

    public LadderGameInfo(String[] participants, String[] result, int height) throws Exception {
        this(List.of(participants), List.of(result), height);
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

    private static void ResultSizeValidationCheck(int participantsSize, int resultsSize) throws InvalidResultSizeException {
        if (participantsSize != resultsSize)
            throw new InvalidResultSizeException();
    }

    private static void ladderHeightValidationCheck(int height) throws InvalidLadderHeightException {
        if (height < Constants.MIN_LADDER_HEIGHT || height > Constants.MAX_LADDER_HEIGHT)
            throw new InvalidLadderHeightException();
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

    public List<String> getResults() {
        return results;
    }

    private void validation() throws Exception {
        participantsValidationCheck(participants);
        ResultSizeValidationCheck(participants.size(), results.size());
        ladderHeightValidationCheck(height);
    }

}
