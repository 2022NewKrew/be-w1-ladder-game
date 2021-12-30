package step3LadderGame.view.input;

import step2LadderGame.domain.ladderConfig.LadderConfig;
import step2LadderGame.view.input.InputInterface;
import step3LadderGame.domain.ladderConfig.LadderIncludeParticipantsConfig;
import step2LadderGame.exception.ladderException.ConsoleInputCountExceededException;
import step2LadderGame.util.consoleInput.InputConsole;
import step2LadderGame.util.consoleInput.PositiveNumberInputConsole;
import step2LadderGame.util.consoleInput.StringListInputConsole;

import java.util.List;

public class HeightAndParticipantsInputInterface implements InputInterface {

    @Override
    public LadderConfig inputLadderConfig() throws ConsoleInputCountExceededException {
        final InputConsole<Integer> positiveNumberInput = new PositiveNumberInputConsole();
        final InputConsole<List<String>> stringListInputConsole = new StringListInputConsole();

        final List<String> nameList = stringListInputConsole.read("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        final int height = positiveNumberInput.read("최대 사다리 높이는 몇 개인가요?");

        return new LadderIncludeParticipantsConfig(nameList, height);
    }
}
