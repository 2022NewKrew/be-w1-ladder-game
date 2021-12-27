package domain;

public class LadderGame {

    private Participant participant;
    private Ladder ladder;

    public LadderGame(Participant participant, int height) {
        this.participant = participant;
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
