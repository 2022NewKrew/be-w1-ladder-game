package main.java.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGenerator {
    private static final int MIN_HEIGHT = 1;
    private static final String MESSAGE_MIN_HEIGHT = "사다리 높이는 1이상이어야 합니다.";
    private LineGenerator lineGenerator;

    public LadderGenerator(){
        this.lineGenerator = new LineGenerator();
    }

    private void validate(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException(MESSAGE_MIN_HEIGHT);
        }
    }

    public Ladder generateLadder(int numberOfPlayers, int height) {
        validate(height);
        List<Line> lines = new ArrayList<>();
        for(int i=0; i<height; i++){
            lines.add(lineGenerator.generateLine(numberOfPlayers));
        }
        return new Ladder(lines);
    }
}
