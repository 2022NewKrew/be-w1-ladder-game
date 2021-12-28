package domain;

import domain.ladder.Ladder;

public class LadderGame {

    private final Ladder ladder;

    public LadderGame(Participant participant, int height) {
        this.ladder = new Ladder(participant.howManyParticipant(), height);
    }

    public void play() {
        ladder.initLadder();
        printLadder();
    }

    private void printLadder() {
        System.out.println(ladder.generateLadderShape());
    }

}
