package main.java;

import java.util.ArrayList;
import java.util.List;

public class LineGenerator {
    private void generateFirstPoint(List<Point> points){
        points.add(Point.randomPoint());
    }

    private void generateIntermediatePoint(List<Point> points, int numberOfPlayers){
        Point prePoint = points.get(points.size()-1);
        for(int i = 1; i < numberOfPlayers-1; i++){
            prePoint = Point.next(prePoint);
            points.add(prePoint);
        }
    }

    private void generateLastPoint(List<Point> points){
        Point prePoint = points.get(points.size()-1);
        points.add(Point.last(prePoint));
    }

    public Line generateLine(int numberOfPlayers){
        List<Point> points = new ArrayList<>();
        generateFirstPoint(points);
        generateIntermediatePoint(points, numberOfPlayers);
        generateLastPoint(points);
        points.forEach(point -> System.out.print(point.move()));
        System.out.println();
        return new Line(points);
    }
}
