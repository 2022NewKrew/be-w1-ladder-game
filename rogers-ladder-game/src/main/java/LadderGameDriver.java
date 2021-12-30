import domain.Ladder;
import dto.InputDto;
import dto.OutputDto;
import factory.LadderFactory;
import view.InputView;
import view.OutputView;

import java.util.NoSuchElementException;

public class LadderGameDriver {
    public static void main(String[] args) {
        try {
            InputDto inputDto = InputView.input(System.in).orElseThrow();
            Ladder ladder = LadderFactory.getInstance(inputDto).orElseThrow();
            OutputView.output(new OutputDto(ladder));
        }catch (NoSuchElementException noSuchElementException){
            System.out.println("시스템을 종료합니다.");
        }
    }
}
