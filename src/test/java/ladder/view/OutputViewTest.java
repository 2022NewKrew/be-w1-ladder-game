package ladder.view;

import ladder.domain.Ladder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static ladder.LadderMain.MAX_LENGTH;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OutputViewTest {

    // ---
    // 출력 값을 테스트 하기 위한 선언
    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }
    // ---

    @Test
    @DisplayName("사람 이름 출력시 최대글자를 정확히 출력하는지")
    void name_output_test() {
        List<String> people = List.of("pobi,honux,crong,jk".split(","));
        OutputView outputView = new OutputView();
        outputView.drawPeople(people);
        assertEquals(outputStreamCaptor.toString().split("\n")[0].length()
                // '|' 그려지는 위치 고려하여 (MAX_LENGTH+1)
                , people.size() * (MAX_LENGTH+1));
    }

    @Test
    @DisplayName("사다리 출력시 최대글자를 정확히 출력하는지")
    void ladder_output_test() {
        List<String> people = List.of("pobi,honux,crong,jk".split(","));
        final int ladderHeight = 5;
        Ladder.of(people, ladderHeight).drawLadder();
        String[] ladderRows = outputStreamCaptor.toString().split("\n");

        assertEquals(ladderRows.length, ladderHeight);

        for (String ladderRow : ladderRows) {
            assertEquals(ladderRow.length(),
                    // '|'는 사람수만큼 + (' ' or '_'는 사람 사이공간 * 그릴 수 있는 최대 길이)
                    people.size() + (people.size()-1)*MAX_LENGTH);
        }
    }

}