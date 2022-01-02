import Ladder.DTO.InputDTO;
import Ladder.domain.Ladder;
import Ladder.view.InputView;

public class Main {
    public static void main(String[] args) {
        Ladder ladder = new Ladder(new InputDTO(InputView.inputPeopleName(), InputView.inputHeight()));
        ladder.printLadder();
    }
}