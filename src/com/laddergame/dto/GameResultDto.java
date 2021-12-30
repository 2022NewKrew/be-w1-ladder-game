package com.laddergame.dto;

import com.laddergame.domain.GameResult;
import com.laddergame.domain.GameResults;

import java.util.NoSuchElementException;

import static com.laddergame.util.ExceptionMessages.NO_SUCH_PARTICIPANT_EXCEPTION;

public class GameResultDto {
    private static String participantResult;

    GameResultDto(String result) {
        participantResult = result;
    }

    public String getParticipantResult() {
        return participantResult;
    }

    public static GameResultDto from(GameResults gameResults, String targetParticipant) throws NoSuchElementException {
        GameResult targetGameResult = gameResults.findByParticipantName(targetParticipant);

        if (targetGameResult == null) {
            throw new NoSuchElementException(NO_SUCH_PARTICIPANT_EXCEPTION);
        }
        return new GameResultDto(targetGameResult.getResult());
    }
}
