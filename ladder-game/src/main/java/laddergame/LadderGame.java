package laddergame;


import laddergame.ladder.Ladder;
import laddergame.ladder.LadderView;

public class LadderGame {
    public static void main(String[] args) {
        LadderView ladderView = new LadderView();

        String participants = ladderView.participantInputUI();
        String result = ladderView.resultInputUI();
        int height = ladderView.heightInputUI();

        Ladder ladder = new Ladder(participants, result, height);

        ladderView.participantOutputUI(ladder);
        ladderView.ladderOutputUI(ladder);
        ladderView.resultOutputUI(ladder);

        ladder.repeatPerson();
        ladderView.printResult(ladder);


    }
}