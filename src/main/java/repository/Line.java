package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Line {
    private final List<Point> line = new ArrayList<>();
    public Line() { }

    public void addPoint(Point element) { line.add(element); }
    public Stream<Point> getLineStream() { return line.stream(); }
    public boolean getPointValid(int idx) { return line.get(idx).getConnected(); }
}
