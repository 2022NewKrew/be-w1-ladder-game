package Ladder.domain;

import Ladder.DTO.InputDTO;
import Ladder.DTO.outputLineDTO;
import Ladder.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final NameLine nameLine;
    private final List<HorizontalBarLine> horizBarArr;

    public Ladder(InputDTO param) {
        List<String> nameArray = param.getNameArray();
        int arrWidth = nameArray.size() - 1;
        int arrHeight = param.getHeight();

        nameLine = new NameLine(nameArray);
        horizBarArr = new ArrayList<>();

        for (int i = 0; i < arrHeight; i++) {
            horizBarArr.add(new HorizontalBarLine(arrWidth));
        }
    }

    public void printLadder() {
        OutputView.printLine(new outputLineDTO(nameLine.getPrintLine()));

        for (HorizontalBarLine r : horizBarArr) {
            OutputView.printLine(new outputLineDTO(r.getPrintLine()));
        }
    }
}
