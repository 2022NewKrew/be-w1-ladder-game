package Ladder4.Domain;

import Ladder4.View.UserInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ladder {

    private final int bridgeSize;
    private final String[] people;
    private final List<Line> ladderLines = new ArrayList<>();
    private final UserInterface ui = new UserInterface();

    public Ladder(int bridgeSize) {
        people = ui.inputLadderCols();
        final int height = ui.inputLadderRowSize();
        this.bridgeSize = bridgeSize;

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
