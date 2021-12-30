package com.kakao.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import com.kakao.domain.player.Player;
import com.kakao.util.RandomUtil;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class LadderPrinterTest {

    private static MockedStatic<RandomUtil> randomUtil;

    private final LadderPrinter ladderPrinter = new LadderPrinter();

    @BeforeAll
    static void beforeAll() {
        randomUtil = mockStatic(RandomUtil.class);
    }

    @AfterAll
    static void afterAll() {
        randomUtil.close();
    }

    @DisplayName("한 칸의 공백을 기준으로 플레이어들의 정제된 이름이 출력된다.")
    @Test
    void generatePlayerNames_() {
        // given
        String expectedOutput = "  a    ab    abc  abcd  abcde ";
        List<Player> players = List.of(Player.create("a"), Player.create("ab"),
            Player.create("abc"),
            Player.create("abcd"), Player.create("abcde"));

        // when
        String output = ladderPrinter.generatePlayerNames(players);

        // then
        assertThat(output).isEqualTo(expectedOutput);
    }

    @DisplayName("입력한 가로, 세로 크기에 맞게 사다리가 출력된다.")
    @Test
    void generateLadder_WidthXHeight_LadderOutput() {
        // given
        int WIDTH = 4;
        int HEIGHT = 2;
        String expectedOutput = "  |-----|     |-----|\n"
                              + "  |     |-----|     |\n";
        when(RandomUtil.nextBoolean())
            .thenReturn(Boolean.TRUE)
            .thenReturn(Boolean.FALSE)
            .thenReturn(Boolean.TRUE)
            .thenReturn(Boolean.FALSE)
            .thenReturn(Boolean.TRUE)
            .thenReturn(Boolean.FALSE);

        // when
        String output = ladderPrinter.generateLadder(Ladder.create(WIDTH, HEIGHT));

        // then
        assertThat(output).isEqualTo(expectedOutput);
    }
}