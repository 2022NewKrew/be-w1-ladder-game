package LadderGame.view;

import LadderGame.domain.*;

import java.util.stream.Collectors;

public class LadderView {
    private static final int MAX_NAME_SIZE = 5;
    private static final int SPACE = 1;

    private final Ladder ladder;
    private final NameView nameView;

    // 생성자
    public LadderView(Ladder ladder) {
        this.ladder = ladder;
        this.nameView = new NameView(ladder.getNames());
    }

    public void showLadder() {
        System.out.println("사다리 결과");
        System.out.println(nameView.showNames() + getLaddersOutput() + getResultOutput());
    }

    private String getLaddersOutput() {
        StringBuilder laddersOutput = new StringBuilder();
        ladder.getLines().stream().map(LineView::new).collect(Collectors.toList()).forEach(laddersOutput::append);
        return laddersOutput.toString();
    }

    private String getResultOutput(){
        StringBuilder resultOutput = new StringBuilder();
        for (String result : ladder.getResultList()) {
            int padding = ((MAX_NAME_SIZE - result.length()) / 2) + SPACE;
            int oddPadding = result.length()%2;
            resultOutput.append(" ".repeat(padding)).append(result).append(" ".repeat(padding-oddPadding));
        }
        resultOutput.append("\n");
        return resultOutput.toString();
    }
}
