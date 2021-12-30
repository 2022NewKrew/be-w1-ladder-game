package domain;

import repository.Ladder;
import repository.Line;
import repository.Point;

public class LadderMaker {
    private final RandomController randomController;
    public LadderMaker(){
        randomController = new RandomController();
    }

    public void makeLadder(Ladder ladder){
        for(int row = 0; row < ladder.getHeightOfLadder(); row++) {
            makeRow(ladder);
        }
    }

    public void makeRow(Ladder ladder){
        Line line = new Line();
        line.addPoint(new Point(0, randomController.getRandomBoolean()));

        for(int column = 1; column < ladder.getNumOfPeople() - 1; column++){
            boolean valid = !line.getPointValid(column - 1) && randomController.getRandomBoolean();
            Point point = new Point(column, valid);
            line.addPoint(point);
        }
        ladder.addConnectedInfo(line);
    }
}
