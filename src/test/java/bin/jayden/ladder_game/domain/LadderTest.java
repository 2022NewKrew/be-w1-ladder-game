package bin.jayden.ladder_game.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LadderTest {

    @Test
    public void makeLadderTest() {
        // given
        int width = 5;
        int height = 5;

        // when
        Ladder ladder = new Ladder(width, height);

        // then
        String toString = ladderRowsToString(ladder.getLadderRows());
        assertThat(toString).doesNotContain(Constants.CONSECUTIVE_VALUE);
        assertThat(toString.length()).isEqualTo(width * height);
    }

    private String ladderRowsToString(List<LadderRow> ladderRows) {
        StringBuilder stringBuilder = new StringBuilder();
        for (LadderRow row : ladderRows) {
            row.getRow().forEach(isLine -> stringBuilder.append(isLine ? 1 : 0));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

}
