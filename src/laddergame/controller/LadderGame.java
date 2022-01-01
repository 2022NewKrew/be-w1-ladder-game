package laddergame.controller;

import laddergame.domain.Ladder;
import laddergame.dto.LadderGameInfo;
import laddergame.view.LadderGameView;

import java.util.List;

public class LadderGame {
    private LadderGameView view;
    private Ladder ladder;
    private List<String> people;

    public LadderGame() {
        view = new LadderGameView();
    }

    public void startGame() {
        LadderGameInfo gameInfo = view.inputLadderGameInfo();
        makePeople(gameInfo);
        makeLadder(gameInfo);
        printLadderGameResult();
    }

    private void makePeople(LadderGameInfo gameInfo) {
        this.people = gameInfo.getPeopleNames();
    }

    private void makeLadder(LadderGameInfo gameInfo) {
        int width = people.size() - 1;
        int height = gameInfo.getLadderHeight();
        ladder = new Ladder(width, height);
        ladder.makeLadder();
    }

    private void printLadderGameResult() {
        view.printLadderGameResult(people, ladder);
    }
}