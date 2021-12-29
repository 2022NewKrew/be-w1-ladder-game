package Ladder;

import Ladder.DTO.InputDTO;
import Ladder.DTO.outputLineDTO;
import Ladder.IOManager.OutputManager;

public class Ladder {
    private final HorizBarLine[] horizBarArr;

    public Ladder(InputDTO param) {
        int arrWidth = param.getNumPeople() - 1;
        int arrHeight = param.getHeight();

        horizBarArr = new HorizBarLine[arrHeight];

        for (int i = 0; i < arrHeight; i++) {
            horizBarArr[i] = new HorizBarLine(arrWidth);
        }
    }

    /* Return : Nothing
     * 사다리 출력하는 함수
     */
    public void printLadder() {
        for (HorizBarLine r : horizBarArr) {
            OutputManager.printLine(new outputLineDTO(r));
        }
    }
}
