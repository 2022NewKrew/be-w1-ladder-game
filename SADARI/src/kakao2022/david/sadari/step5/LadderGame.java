package kakao2022.david.sadari.step5;

import kakao2022.david.sadari.step5.domain.Ladder;
import kakao2022.david.sadari.step5.view.LadderUI;

import java.util.List;

public class LadderGame {

    public static void startGame() {
        LadderUI ladderUI = new LadderUI();
        List<String> peopleList = ladderUI.inputPeople();
        int ladderHeight = ladderUI.inputLadderHeight();
        List<String> resultList = ladderUI.inputResult();
        Ladder ladder = new Ladder(peopleList, ladderHeight, resultList);
        ladderUI.printLadder(ladder);
        ladderUI.printGameResult(ladder.getGameResult());
    }

    public static void main(String[] args) {
        LadderGame.startGame();
    }
}