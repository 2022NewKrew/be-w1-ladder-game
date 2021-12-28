import java.util.ArrayList;
import java.util.List;

public class Line {

    private int id;
    private int height;
    private List<Connection> connections = new ArrayList<>();

    public Line(int id, int height) {
        this.id = id;
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

    public int getId() {
        return id;
    }
}
