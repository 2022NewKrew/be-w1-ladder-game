package ladder.domain;

import ladder.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public final class Ladder {
    private final int width;
    private final int height;
    private final List<String> result = new ArrayList<>();
    private final RandomBooleanGenerate randomBooleanGenerate = new RandomBooleanGenerate();
    private final OutputView outputView = new OutputView();

    private Ladder(List<String> people, int ladderHeight) {
        this.width = people.size() * 2 - 1;
        this.height = ladderHeight;
        initLadder();
    }

    public static Ladder of(List<String> people, int ladderHeight){
        return new Ladder(people, ladderHeight);
    }

    private void initLadder() {
        for(int i = 0; i < this.height; ++i) {
            result.add(getLadderString());
        }
    }

    private String getLadderString() {
        StringBuilder ladderStringBuilder = new StringBuilder();
        for(int i = 0; i < width; i++) {
            ladderStringBuilder.append(getLadderShape(i));
        }
        return ladderStringBuilder.toString();
    }

    private String getLadderShape(int number) {
        if(checkEvenNumber(number)) {
            return Shape.COL.getShape();
        }
        if(randomBooleanGenerate.checkCanDraw()){
            return Shape.ROW.getShape();
        }
        return Shape.BLANK_ROW.getShape();
    }

    private boolean checkEvenNumber(int number) {
        return (number % 2 == 0);
    }

    public Ladder drawPeople(List<String> people) {
        outputView.drawPeople(people);
        return this;
    }

    public Ladder drawLadder() {
        outputView.drawLadder(result);
        return this;
    }
}
