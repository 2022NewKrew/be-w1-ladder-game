package laddergame;


import laddergame.ladder.Ladder;
import laddergame.ladder.LadderView;

public class LadderGame {
    public static void main(String[] args) {
        LadderView ladderView = new LadderView();

        String participants = ladderView.participantInputUI();
        int height = ladderView.heightInputUI();

        Ladder ladder = new Ladder(participants, height);

        ladderView.participantOutputUI(ladder);
        ladderView.ladderOutputUI(ladder);


    }
}