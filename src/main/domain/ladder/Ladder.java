package main.domain.ladder;

import main.domain.line.Line;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ladder {

    private final int height;
    private final Map<String, Integer> nameIndexMap = new HashMap<>();
    private final List<Line> lines = new ArrayList<>();

    public Ladder(String[] players, String[] results, int height) {
        this.height = height;
        for (int i = 0; i < players.length; i++) {
            lines.add(new Line(players[i], results[i], height));
            nameIndexMap.put(players[i], i);
        }
    }

    public String getResult(int position) {
        Line line = lines.get(position);
        for (int depth = 0; depth < height; depth++) {
            line = getConnectedLineIfConnected(line, depth);
        }

        return line.getResult();
    }

    public String getResult(String name) {
        Integer lineIndex = nameIndexMap.get(name);
        return getResult(lineIndex);
    }

    private Line getConnectedLineIfConnected(Line line, int depth) {
        if (line.isConnected(depth)) {
            return line.getConnectedLine(depth);
        }
        return line;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return lines.size();
    }

    public Line getLine(int position) {
        return this.lines.get(position);
    }
}
