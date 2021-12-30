package Ladder3.Domain;

import Ladder3.View.UserInterface;
import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final int bridgeSize;
    private final String[] people;
    private final int height;
    private final List<Line> ladderLines = new ArrayList<>();
    private final UserInterface ui = new UserInterface();

    public Ladder(int bridgeSize) {
        people = ui.inputLadderCols();
        height = ui.inputLadderRowSize();
        this.bridgeSize = bridgeSize;

        initLadder();
    }

    private void initLadder() {
        for (int i = 0; i < height; i++)
            ladderLines.add(new Line(people.length, bridgeSize));
    }

    @Override
    public String toString() {
        final Drawer drawer = new Drawer(ladderLines, people, bridgeSize);

        // 시각적 구분을 위한 한줄 추가
        return "\n" + drawer.drawNameRow() + drawer.drawLadder();
    }
}
