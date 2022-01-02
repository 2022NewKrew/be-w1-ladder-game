package Ladder.domain;

import java.util.List;

public class NameLine {
    private List<String> names;

    public NameLine(List<String> nameLine) {
        names = nameLine;
    }

    public List<String> getNames() { return names; }
}