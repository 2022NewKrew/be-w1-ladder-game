import java.util.ArrayList;

public class Ladder {
    private final LadderInfo info;
    private final ArrayList<ArrayList<Boolean>> connections;

    public Ladder(LadderInfo info) {
        this.info = info;
        LadderMaker maker = new LadderMaker(info);
        connections = maker.makeConnections();
    }

    public LadderInfo getInfo() {
        return info;
    }
    public ArrayList<ArrayList<Boolean>> getConnections() {
        return connections;
    }
}