package ladderGame.view.input;

import ladderGame.domain.ladderConfig.LadderConfig;
import ladderGame.domain.ladderConfig.LadderIncludeNamesConfig;
import ladderGame.exception.ladderException.ConsoleInputCountExceededException;
import ladderGame.util.consoleInput.InputConsole;
import ladderGame.util.consoleInput.PositiveNumberInputConsole;
import ladderGame.util.consoleInput.StringListInputConsole;

import java.util.List;

public class HeightAndPeopleNamesInputInterface implements InputInterface {

    @Override
    public LadderConfig inputLadderConfig() throws ConsoleInputCountExceededException {
        final InputConsole<Integer> positiveNumberInput = new PositiveNumberInputConsole();
        final InputConsole<List<String>> nameListInput = new StringListInputConsole();

        List<String> nameList = nameListInput.read("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        int height = positiveNumberInput.read("최대 사다리 높이는 몇 개인가요?");

        return LadderIncludeNamesConfig.of(nameList, height);
    }
}
