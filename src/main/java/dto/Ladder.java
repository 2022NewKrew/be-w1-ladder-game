package dto;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<StringBuilder> ladder;

    public Ladder(List<StringBuilder> ladder) {
        this.ladder = ladder;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("\n");
        for (StringBuilder ladderLine : ladder){
            res.append(ladderLine.toString()).append("\n");
        }
        return res.toString();
    }
}
