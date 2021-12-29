package com.laddergame;

import java.util.List;

import static com.laddergame.View.*;

public class LadderGameApplication {
    public static void main(String[] args) {
        String ParticipantNames = inputParticipantName();
        int ladderHeight = inputLadderHeight();

        LadderGame ladderGame = LadderGame.valueOf(ladderHeight, ParticipantNames);
        Lines lines = ladderGame.getLines();
        List<String> participantNames = ladderGame.getParticipantsNames();
        ResultDto resultDto = ResultDto.from(lines);

        outputParticipantNames(participantNames);
        outputLadderGameResult(resultDto.getGameResult());
    }
}
