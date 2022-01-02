import Ladder.DTO.InputDTO;
import Ladder.view.InputView;
import Ladder.domain.Ladder;

public class Main {
    public static void main(String[] args) {
        Ladder ladder = new Ladder(new InputDTO(InputView.inputPeopleName(), InputView.inputHeight()));
        ladder.printLadder();
    }
}