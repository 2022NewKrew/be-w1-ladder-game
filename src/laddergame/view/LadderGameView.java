package laddergame.view;

import laddergame.domain.Ladder;
import laddergame.dto.LadderGameInfo;
import laddergame.view.input.InputInteger;
import laddergame.view.input.InputStringList;
import laddergame.view.output.LadderView;
import laddergame.view.output.PeopleView;

import java.util.List;

public class LadderGameView {
    private final String peopleNameInputMessage = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private final String ladderHeightInputMessage = "최대 사다리 높이는 몇 개인가요?";
    private final String resultMessage = "실행결과";

    public LadderGameView() {
    }

    public LadderGameInfo inputLadderGameInfo() {
        System.out.println(peopleNameInputMessage);
        List<String> names = new InputStringList().getInputValue();

        System.out.println(ladderHeightInputMessage);
        Integer ladderHeight = new InputInteger().getInputValue();

        return new LadderGameInfo(names, ladderHeight);
    }

    public void printLadderGameResult(List<String> people, Ladder ladder) {
        System.out.println(resultMessage);
        new PeopleView(people).print();
        new LadderView(ladder).print();
    }
}