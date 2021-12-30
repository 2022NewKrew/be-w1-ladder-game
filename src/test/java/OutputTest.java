import ladder.LadderGame;
import ladder.dto.InputDTO;
import ladder.dto.OutputDTO;
import ladder.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class OutputTest {

    @Test
    @DisplayName("시다리 결과 출력")
    public void printOutputView() throws IOException {
        //given
        String[] namesOfPeople = {"moook", "lisa", "sam", "ju", "ls"};
        int height = 5;
        //when
        LadderGame ladderGame = new LadderGame(new InputDTO(namesOfPeople, height));
        OutputDTO dto = new OutputDTO(ladderGame.getLadder(),
                ladderGame.getNamesOfPeople());
        //then
        OutputView.printLadderResult(dto);

    }
}
