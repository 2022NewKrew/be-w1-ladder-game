package ladder.domain;

import java.util.ArrayList;
import java.util.Random;

public class Line {

    private final ArrayList<String> bridges;
    private final Random random = new Random();

    public Line(int columnCount) {
        this.bridges = new ArrayList<>();
        makeLine(columnCount);
    }

    private void makeLine(int columnCount){
        for (int j = 0; j < columnCount; j++) {
            bridges.add((j % 2 == 0) ? "|" : makeBridge());
        }
    }

    private String makeBridge() {
        return random.nextBoolean() ? "-" : " ";
    }

    public ArrayList<String> getBridges(){
        return this.bridges;
    }
}
