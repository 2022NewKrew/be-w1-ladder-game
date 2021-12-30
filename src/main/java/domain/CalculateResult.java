package domain;

import repository.Ladder;
import repository.Point;

public class CalculateResult {
    private final Ladder ladder;
    public CalculateResult(Ladder ladder) { this.ladder = ladder; }

    public void calculateResult(){
        for(int row = 0; row < ladder.getHeightOfLadder(); row++) {
            ladder.getConnectedStream(row)
                    .forEach(this::checkConnected);
        }
        ladder.makeResultMapping();
    }

    public void checkConnected(Point line){
        if(!line.getValid()) return;
        ladder.swapPlayerResult(line.getPoint());
    }
}
