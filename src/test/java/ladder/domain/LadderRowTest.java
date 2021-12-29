package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LadderRowTest {

    @Test
    @DisplayName("사다리 Line에서 선을 그릴 수 있는지 확인하는 테스트")
    void test_print_ladder_row() {
        //given
        LadderRow ladderRow = new LadderRow(5);
        List<Boolean> horizonBranch = new ArrayList<>(Arrays.asList(true, false, true, false));
        ladderRow.horizonBranch = horizonBranch;

        //when
        String stringLadderRow = ladderRow.toString();

        //then
        assertEquals("  |-----|     |-----|     |\n", stringLadderRow);
    }
}