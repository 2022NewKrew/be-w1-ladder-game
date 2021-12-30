package kakao2022.david.sadari.step4.domain;

import kakao2022.david.sadari.step4.view.LadderUI;
import java.util.ArrayList;

public class Ladder {
    private ArrayList<String> peopleList = new ArrayList<>();
    private final int countOfPerson;
    private final int ladderHeight;
    private final ArrayList<Line> ladderBoard = new ArrayList<>();

    public Ladder() {
        boolean isDone = false;
        while (!isDone) {
            peopleList = LadderUI.inputPeople();
            isDone = CheckName.checkPeopleList(peopleList);
        }
        countOfPerson = peopleList.size();
        ladderHeight = LadderUI.inputLadderHeight();
    }

    private void makeLine() {
        for (int i = 0; i < ladderHeight; i++) {
            Line line = new Line(countOfPerson);
            ladderBoard.add(line);
        }
    }

    public void startGame() {
        makeLine();
        LadderUI.printPeopleList(peopleList);
        LadderUI.printLadder(ladderBoard);
    }
}
