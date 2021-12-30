package main.domain.line;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final String name;
    private final String result;
    private final int height;
    private final List<Connection> connections = new ArrayList<>();

    public Line(String name, String result, int height) {
        this.name = name;
        this.result = result;
        this.height = height;
        for (int i = 0; i < height; i++) {
            connections.add(new Connection());
        }
    }

    public void connect(Line targetLine, int depth) {
        if (isConnectable(targetLine, depth)) {
            this.connectOneDirection(targetLine, depth);
            targetLine.connectOneDirection(this, depth);
        }
    }

    void connectOneDirection(Line targetLine, int depth) {
        connections.get(depth).connect(targetLine);
    }

    public boolean isConnectable(Line targetLine, int depth) {
        return !isConnected(depth) && !targetLine.isConnected(depth);
    }

    public boolean isConnected(int depth) {
        return connections.get(depth).isConnected();
    }

    public boolean isConnectedTo(Line targetLine, int depth) {
        Line connectedLine = getConnectedLine(depth);
        return connectedLine != null && connectedLine.equals(targetLine);
    }

    public Line getConnectedLine(int depth) {
        return connections.get(depth).getTargetLine();
    }

    public int getHeight() {
        return height;
    }

    public String getName() {
        return name;
    }

    public String getResult() {
        return result;
    }
}
