package Ladder.domain;

import Ladder.DTO.InputDTO;
import Ladder.DTO.outputLineDTO;
import Ladder.domain.HorizBarLine;
import Ladder.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final NameLine nameLine;
    private final List<HorizBarLine> horizBarArr;

    public Ladder(InputDTO param) {
        List<String> nameArray = param.getNameArray();
        int arrWidth = nameArray.size() - 1;
        int arrHeight = param.getHeight();

        nameLine = new NameLine(nameArray);
        horizBarArr = new ArrayList<>();

        for (int i = 0; i < arrHeight; i++) {
            horizBarArr.add(new HorizBarLine(arrWidth));
        }
    }

    public void printLadder() {
        OutputView.printNameLine(new outputLineDTO(nameLine.getNameArray()));

        for (HorizBarLine r : horizBarArr) {
            OutputView.printLine(new outputLineDTO(r.getLine()));
        }
    }
}
