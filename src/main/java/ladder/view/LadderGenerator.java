package ladder.view;

import ladder.domain.Ladder;

import java.io.IOException;

public class LadderGenerator {
    private final String ENTRY_QUESTION = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private final String RESULT_QUESTION = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private final String HEIGHT_QUESTION = "사다리 높이는 몇 개인가요?";

    private final Input input;

    public LadderGenerator(Input input) {
        this.input = input;
    }
    public Ladder generateLadder() throws IOException {
        String stringEntry = input.input(ENTRY_QUESTION);
        String stringResult = input.input(RESULT_QUESTION);
        int height = Integer.parseInt(input.input(HEIGHT_QUESTION));

        return new Ladder(stringEntry, stringResult, height);
    }
}
