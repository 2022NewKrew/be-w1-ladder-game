package com.laddergame.dto;

import com.laddergame.domain.GameResult;

import java.util.Map;

public class ParticipantResultDto {
    private static String participantResult;

    ParticipantResultDto(String result) {
        participantResult = result;
    }

    public String getParticipantResult() {
        return participantResult;
    }

    public static ParticipantResultDto from(GameResult gameResult, String targetParticipant) {
        Map<String, String> matchedGameResult = gameResult.getMatchedGameResults();
        String result = matchedGameResult.get(targetParticipant);
        return new ParticipantResultDto(result);
    }
}
