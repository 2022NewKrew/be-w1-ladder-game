import domain.Ladder;
import dto.InputDto;
import dto.OutputDto;
import factory.LadderFactory;
import view.InputView;
import view.OutputView;

import java.util.Optional;
import java.util.Scanner;

public class LadderGameDriver {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            startGame(scanner);
        }
    }

    private static void startGame(Scanner scanner){
        Optional<InputDto> inputDtoOptional = InputView.input(scanner);
        if(inputDtoOptional.isEmpty()){
            return;
        }

        Optional<Ladder> ladderOptional = LadderFactory.getInstance(inputDtoOptional.get());
        if(ladderOptional.isEmpty()){
            return;
        }

        OutputView.output(new OutputDto(ladderOptional.get()), scanner);
    }
}
