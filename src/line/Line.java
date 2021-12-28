package line;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final String name;
    private final int height;
    private final List<Connection> connections = new ArrayList<>();

    public Line(String name, int height) {
        this.name = name;
        this.height = height;
        for (int i = 0; i < height; i++) {
            connections.add(new Connection());
        }
    }

    public void connect(Line targetLine, int position) {
        connections.get(position).connect(targetLine);
    }

    public boolean isConnectable(int position) {
        return !connections.get(position).isConnected();
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
}
