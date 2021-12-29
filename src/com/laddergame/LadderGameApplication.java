package com.laddergame;

import java.util.List;
import java.util.stream.Collectors;

import static com.laddergame.View.*;

public class LadderGameApplication {

    public static void main(String[] args) {
        String participantNamesString = inputParticipantName();
        Participants participants = new Participants(participantNamesString);
        int participantNumber = participants.participants.size();
        int ladderHeight = inputLadderHeight();

        List<List<Boolean>> result = new LadderGame(participantNumber, ladderHeight).startGame();
        outputParticipantNames(participants.participants.stream()
                .map(participant -> participant.name)
                .collect(Collectors.toList())
        );
        outputLadderGameResult(result);
    }
}
