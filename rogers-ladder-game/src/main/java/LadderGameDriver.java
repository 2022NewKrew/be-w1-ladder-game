import domain.Ladder;
import dto.InputDto;
import dto.OutputDto;
import factory.LadderFactory;
import view.InputView;
import view.OutputView;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class LadderGameDriver {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            InputDto inputDto = InputView.input(scanner).orElseThrow();
            Ladder ladder = LadderFactory.getInstance(inputDto).orElseThrow();

            OutputView.output(new OutputDto(ladder), scanner);
        }catch (NoSuchElementException noSuchElementException){
            System.out.println("시스템을 종료합니다.");
        }
    }
}
