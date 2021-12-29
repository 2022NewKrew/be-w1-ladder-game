package domain;

import view.LadderInfoGetter;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private int heightOfLadder;

    private List<String> people = new ArrayList<String>();
    private List<Line> ladder = new ArrayList<Line>();

    public Ladder() {
        LadderInfoGetter ladderInfoGetter = new LadderInfoGetter();
        ladderInfoGetter.getInfoFromClient();
        people = ladderInfoGetter.getPeople();
        heightOfLadder = ladderInfoGetter.getHeightOfLadder();
        for(int i = 0 ; i < heightOfLadder ; i++) {
            Line line = new Line(people.size());
            ladder.add(line);
        }
    }

    public int getHeightOfLadder() {
        return heightOfLadder;
    }

    public int getCountOfPerson() {
        return people.size();
    }

    public Line getLine(int i) {
        return ladder.get(i);
    }

    public List<String> getPeople() {
        return people;
    }
}