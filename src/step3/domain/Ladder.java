package step3.domain;

import step3.view.InputView;

import java.util.*;

public class Ladder {

    private Player people;
    private LadderHeight height;
    private List<Line> ladder;

    public Ladder(){
        InputView input = InputView.getInstance();
        this.people = input.inputPeople();
        this.height = input.inputHeight();
        makeLadder();
    }
    public Ladder(Player people, LadderHeight height) {
        this.people = people;
        this.height = height;
        makeLadder();
    }

    //make ladder
    private void makeLadder() {
        ladder = new ArrayList<Line>(height.getHeightOfLadder());
        for (int i = 0; i < height.getHeightOfLadder(); i++) {
            Line line = new Line(people.getCountOfPeople());
            ladder.add(line);
        }
    }

    public List<Line> getLadder(){
        return this.ladder;
    }

    public Player getPeople(){
        return this.people;
    }

    public LadderHeight getHeight(){
        return this.height;
    }

}