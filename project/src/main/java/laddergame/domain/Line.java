package laddergame.domain;

import laddergame.util.Util;
import java.util.ArrayList;
import java.util.List;

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

    public int findAvailableDirection(int currentPosition){
        if(currentPosition != 0 && points.get(currentPosition-1).getIsStair()){
            return -1;
        }
        if(currentPosition != points.size() && points.get(currentPosition).getIsStair()){
            return 1;
        }
        return 0;
    }

    public String toString(){
        StringBuilder result = new StringBuilder("  |");
        for(Point point : points){
            result.append(point.toString());
        }
        return result.toString();
    }
}
