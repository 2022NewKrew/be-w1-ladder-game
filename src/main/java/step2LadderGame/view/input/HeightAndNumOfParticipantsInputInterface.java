package step2LadderGame.view.input;

import step2LadderGame.domain.ladderConfig.LadderConfig;
import step2LadderGame.exception.ladderException.ConsoleInputCountExceededException;
import step2LadderGame.util.consoleInput.PositiveNumberInputConsole;

public class HeightAndNumOfParticipantsInputInterface implements InputInterface {

    @Override
    public LadderConfig inputLadderConfig() throws ConsoleInputCountExceededException {
        final PositiveNumberInputConsole positiveNumberInput = new PositiveNumberInputConsole();

        final int numOfPeople = positiveNumberInput.read("참여할 사람은 몇 명인가요?");
        final int height = positiveNumberInput.read("최대 사다리 높이는 몇 개인가요?");

        return new LadderConfig(numOfPeople, height);
    }
}
