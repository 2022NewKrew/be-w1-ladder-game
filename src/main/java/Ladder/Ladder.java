package Ladder;

import Ladder.DTO.InputDTO;
import Ladder.DTO.outputLineDTO;
import Ladder.DTO.outputNameDTO;
import Ladder.IOManager.OutputManager;

public class Ladder {
    private final NameLine nameLine;
    private final HorizBarLine[] horizBarArr;

    public Ladder(InputDTO param) {
        String[] nameArray = param.getNameArray();
        int arrWidth = nameArray.length - 1;
        int arrHeight = param.getHeight();

        nameLine = new NameLine(nameArray);
        horizBarArr = new HorizBarLine[arrHeight];

        for (int i = 0; i < arrHeight; i++) {
            horizBarArr[i] = new HorizBarLine(arrWidth);
        }
    }

    public void printLadder() {
        OutputManager.printLine(new outputNameDTO(nameLine));

        for (HorizBarLine r : horizBarArr) {
            OutputManager.printLine(new outputLineDTO(r));
        }
    }
}
