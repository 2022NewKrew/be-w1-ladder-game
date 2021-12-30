package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderLine {

    private List<Boolean> line;

    public void makeLine(ConnectStrategy connectStrategy, int width) {
        line = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            line.add(decideNextConnection(connectStrategy, i));
        }
    }

    public List<Boolean> getLine() {
        return line;
    }

    private boolean decideNextConnection(ConnectStrategy connectStrategy, int idx) {
        if (idx > 0 && line.get(idx - 1)) {
            return false;
        }
        return connectStrategy.isConnect();
    }
}
