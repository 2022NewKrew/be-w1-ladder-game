package LadderMaker;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Line {
    private List<Boolean> line = new ArrayList<>();
    public Line() { }

    public void addElement(Boolean element) { line.add(element); }
    public Stream<Boolean> getLineStream() { return line.stream(); }
    public Boolean getElement(int idx) { return line.get(idx); }
}
