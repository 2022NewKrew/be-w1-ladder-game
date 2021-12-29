import ladder.LadderGame;
import ladder.dto.InputDTO;
import ladder.dto.OutputDTO;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {


        InputDTO inputComponent = InputView.inputComponentOfLadder();
        LadderGame game = new LadderGame(inputComponent);

        OutputView.printLadderResult(new OutputDTO(game.getLadder(),
                inputComponent.getNamesOfPeople()));
    }
}