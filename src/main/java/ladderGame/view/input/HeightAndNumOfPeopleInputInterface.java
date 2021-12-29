package ladderGame.view.input;

import ladderGame.domain.ladderConfig.LadderConfig;
import ladderGame.exception.ladderException.ConsoleInputCountExceededException;
import ladderGame.util.consoleInput.PositiveNumberInputConsole;

public class HeightAndNumOfPeopleInputInterface implements InputInterface {

    @Override
    public LadderConfig inputLadderConfig() throws ConsoleInputCountExceededException {
        final PositiveNumberInputConsole positiveNumberInput = new PositiveNumberInputConsole();

        int numOfPeople = positiveNumberInput.read("참여할 사람은 몇 명인가요?");
        int height = positiveNumberInput.read("최대 사다리 높이는 몇 개인가요?");

        return LadderConfig.of(numOfPeople, height);
    }
}
