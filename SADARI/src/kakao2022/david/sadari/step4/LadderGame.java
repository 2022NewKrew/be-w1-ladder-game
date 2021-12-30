package kakao2022.david.sadari.step4;

import kakao2022.david.sadari.step4.domain.Ladder;
import kakao2022.david.sadari.step4.view.LadderUI;

import java.util.List;

public class LadderGame {

    public static void startGame() {
        LadderUI ladderUI = new LadderUI();
        List<String> peopleList = ladderUI.inputPeople();
        int ladderHeight = ladderUI.inputLadderHeight();
        Ladder ladder = new Ladder(peopleList, ladderHeight);
        ladderUI.printLadder(ladder);
    }

    public static void main(String[] args) {
        LadderGame.startGame();
    }
}