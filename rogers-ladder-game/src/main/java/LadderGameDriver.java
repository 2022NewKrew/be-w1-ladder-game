import domain.Ladder;
import dto.InputDto;
import dto.OutputDto;
import factory.LadderFactory;
import view.InputView;
import view.OutputView;

import java.util.Objects;

public class LadderGameDriver {
    public static void main(String[] args) {
        InputDto inputDto = Objects.requireNonNull(InputView.input(System.in));
        Ladder ladder = LadderFactory.getInstance(inputDto);
        OutputView.output(new OutputDto(ladder));
    }
}
