package service.domain;

import java.util.List;

public class LadderLine {
    private final List<Boolean> isLadderConnected;

    public LadderLine(List<Boolean> isLadderConnected) {
        this.isLadderConnected = isLadderConnected;
    }

    public List<Boolean> getIsLadderConnected() {
        return isLadderConnected;
    }
}
