package step3.domain;

import step3.view.InputView;

import java.util.*;

public class Ladder {

    private Player people;
    private LadderHeight height;
    private LadderResult result;
    private List<Line> ladder;

    public Ladder(){
        InputView input = InputView.getInstance();
        this.people = input.inputPeople();
        this.result = input.inputResult();
        this.height = input.inputHeight();
        makeLadder();
        play();
    }

    //make ladder
    private void makeLadder() {
        ladder = new ArrayList<Line>(height.getHeightOfLadder());
        for (int i = 0; i < height.getHeightOfLadder(); i++) {
            Line line = new Line(people.getCountOfPeople());
            ladder.add(line);
        }
    }

    private void playLine(List<Boolean> points) {
        for (int i=0;i<points.size();i++){
            this.result.swap(i, points.get(i));
        }
    }
    public void play() {
        for (Line line : ladder) {
            playLine(line.getPoints());
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

    public LadderResult getResult() { return this.result; }

}