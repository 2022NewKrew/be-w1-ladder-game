package main.java.domain;

import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Point> points ;

    public Line(List<Point> points){
        this.points = points;
    }

    public List<Point> points(){
        return Collections.unmodifiableList(points);
    }

    public int move(int position){
        return position + points.get(position).move();
    }
}
