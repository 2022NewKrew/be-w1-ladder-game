import DTO.InputDTO;
import DTO.OutputDTO;
import domain.Ladder;

import view.LadderInfoGetter;
import view.LadderRenderer;

public class LadderGame {
    public static void main(String[] args) {
        InputDTO inputDTO = LadderInfoGetter.getInfoFromClient();
        Ladder ladder = new Ladder(inputDTO);
        OutputDTO outputDTO = new OutputDTO(ladder);
        LadderRenderer ladderRenderer = new LadderRenderer(outputDTO);
        ladderRenderer.printAll();
    }
}


