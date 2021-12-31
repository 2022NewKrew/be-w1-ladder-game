package view;

import domain.Ladder;
import domain.Line;

import java.util.ArrayList;
import java.util.List;

public class LadderView {

    private List<Line> ladder = new ArrayList<>();


    public LadderView(List<Line> ladder) {
        this.ladder = ladder;
    }

    public void printLadder() {
        for (Line line: ladder) {
            System.out.println(line);
        }
    }
}
