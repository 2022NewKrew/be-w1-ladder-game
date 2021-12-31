package bin.jayden.ladder_game.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LadderRowTest {
    @Test
    public void ladderRowTest() {
        // given
        int width = 5;
        // when
        LadderRow ladderRow = new LadderRow(width, new TrueLineGenerator());

        // then
        assertThat(ladderRow.getIsLine(0)).isEqualTo(true);
        assertThat(ladderRow.getRow().toString()).isEqualTo("[true, false, true, false]");
    }
}