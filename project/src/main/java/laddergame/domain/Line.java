package laddergame.domain;

import laddergame.util.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Line {
    private List<Point> points = new ArrayList<>();

    public Line(int countOfPerson){
        for(int i=0; i<countOfPerson-1; i++){
            addPoint(new Point(Util.generateTrueOrFalseByRandom()));
        }
    }

    public void addPoint(Point newPoint) {
        points.add(removeStairIfDoubleStair(newPoint));
    }

    private Point removeStairIfDoubleStair(Point newPoint){
        if(points.isEmpty()){
            return newPoint;
        }
        if (points.get(points.size()-1).getIsStair() && newPoint.getIsStair()){
            newPoint.setIsStair(false);
            return newPoint;
        };
        return newPoint;
    }

    public String toString(){
        StringBuilder result = new StringBuilder("  |");
        for(Point point : points){
            result.append(point.toString());
        }
        return result.toString();
    }
}
