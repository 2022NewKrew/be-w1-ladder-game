package step5LadderGame.view.input;

import step2LadderGame.domain.ladderConfig.LadderConfig;
import step2LadderGame.view.input.InputInterface;
import step2LadderGame.exception.ladderException.ConsoleInputCountExceededException;
import step2LadderGame.util.consoleInput.InputConsole;
import step2LadderGame.util.consoleInput.PositiveNumberInputConsole;
import step2LadderGame.util.consoleInput.StringListInputConsole;
import step5LadderGame.domain.ladderConfig.LadderIncludeParticipantsAndResultsConfig;

import java.util.List;

public class HeightAndParticipantsAndResultInputInterface implements InputInterface {

    @Override
    public LadderConfig inputLadderConfig() throws ConsoleInputCountExceededException {
        final InputConsole<List<String>> stringListInputConsole = new StringListInputConsole();
        final InputConsole<Integer> positiveNumberInput = new PositiveNumberInputConsole();

        final List<String> participants = stringListInputConsole.read("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        List<String> results = stringListInputConsole.read("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        results = repeatInputIfParticipantsSizeNotEqualResultsSize(stringListInputConsole, participants, results);

        final int height = positiveNumberInput.read("최대 사다리 높이는 몇 개인가요?");

        return new LadderIncludeParticipantsAndResultsConfig(participants, results, height);
    }

    private List<String> repeatInputIfParticipantsSizeNotEqualResultsSize(InputConsole<List<String>> stringListInputConsole, List<String> participants, List<String> results) {
        while (participants.size() != results.size()) {
            System.out.println("참여자 수 만큼 결과를 입력해주세요.");
            results = stringListInputConsole.read("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        }
        return results;
    }
}
