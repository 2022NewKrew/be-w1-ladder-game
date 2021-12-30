package LadderGame.view;

import LadderGame.domain.*;

import java.util.stream.Collectors;

public class LadderView {

    private final Ladder ladder;
    private final NameView nameView;

    // 생성자
    public LadderView(Ladder ladder) {
        this.ladder = ladder;
        this.nameView = new NameView(ladder.getNames());
    }

    @Override
    public String toString() {
        return this.nameView + getLaddersOutput();
    }

    private String getLaddersOutput() {
        StringBuilder laddersOutput = new StringBuilder();
        ladder.getLines().stream().map(LineView::new).collect(Collectors.toList()).forEach(laddersOutput::append);
        return laddersOutput.toString();
    }
}
