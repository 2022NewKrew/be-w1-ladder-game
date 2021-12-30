package bin.jayden.ladder_game.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LadderTest {

    @Test
    public void makeLadderTest() {
        //given
        int width = 5;
        int height = 5;

        //when
        Ladder ladder = new Ladder(width, height);

        //then
        String toString = ladder.getLadderRows().toString();
        assertThat(toString).doesNotContain(Constants.CONSECUTIVE_VALUE);
        assertThat(toString.length()).isEqualTo(30);
    }

}
