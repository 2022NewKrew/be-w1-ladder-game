package com.laddergame;

import java.util.List;

import static com.laddergame.View.*;

public class LadderGameApplication {
    public static void main(String[] args) {
        String ParticipantNames = inputParticipantName();
        int ladderHeight = inputLadderHeight();

        LadderGame ladderGame = LadderGame.valueOf(ladderHeight, ParticipantNames);
        List<List<Boolean>> result = ladderGame.getResult();
        List<String> participantNames = ladderGame.getParticipantsNames();

        outputParticipantNames(participantNames);
        outputLadderGameResult(result);
    }
}
