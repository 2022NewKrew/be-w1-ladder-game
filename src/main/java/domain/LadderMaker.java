package domain;

import repository.Line;
import repository.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderMaker {
    Random random = new Random();
    public LadderMaker(){ }

    public List<Line> makeConnectedInfo(int heightOfLadder, int numOfPeople){
        List<Line> connectedInfo = new ArrayList<>();
        for(int row = 0; row < heightOfLadder; row++) {
            connectedInfo.add(makeRow(numOfPeople));
        }
        return connectedInfo;
    }

    private Line makeRow(int numOfPeople){
        Line line = new Line();
        line.addPoint(new Point(0, random.nextBoolean()));

        for(int column = 1; column < numOfPeople - 1; column++){
            boolean valid = !line.getPointValid(column - 1) && random.nextBoolean();
            Point point = new Point(column, valid);
            line.addPoint(point);
        }
        return line;
    }
}
