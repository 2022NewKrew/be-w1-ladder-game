import java.util.ArrayList;

public class LadderGameView {
    private final String peopleNameInputMessage = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private final String ladderHeightInputMessage = "최대 사다리 높이는 몇 개인가요?";
    private final String resultMessage = "실행결과";

    public LadderGameView() {
    }

    public LadderGameInfo inputLadderGameInfo() {
        ArrayList<String> peopleNames = new InputArrayListString(peopleNameInputMessage).getInputValue();
        Integer ladderHeight = new InputInteger(ladderHeightInputMessage).getInputValue();

        return new LadderGameInfo(peopleNames, ladderHeight);
    }

    public void printLadderGameResult(ArrayList<String> people, Ladder ladder) {
        System.out.println(resultMessage);
        new PeopleView(people).print();
        new LadderView(ladder).print();
    }
}