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

    public void connect(Line targetLine, int position) {
        if (isConnectable(targetLine, position)) {
            this.setConnection(targetLine, position);
            targetLine.setConnection(this, position);
        }
    }

    public void setConnection(Line targetLine, int position) {
        connections.get(position).connect(targetLine);
    }

    public boolean isConnectable(Line targetLine, int position) {
        return !isConnected(position) && !targetLine.isConnected(position);
    }

    public boolean isConnected(int position) {
        return connections.get(position).isConnected();
    }

    public boolean isConnectedTo(Line targetLine, int position) {
        Line connectedLine = getConnectedLine(position);
        return connectedLine != null && connectedLine.equals(targetLine);
    }

    public Line getConnectedLine(int position) {
        return connections.get(position).getTargetLine();
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
