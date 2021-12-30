package com.kakao.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    private final int WIDTH = 4;
    private final int HEIGHT = 5;

    @DisplayName("(WIDTH - 1) x HEIGHT 크기의 사다리를 만든다.")
    @Test
    void create_WidthHeight_Ladder() {
        Ladder ladder = Ladder.create(WIDTH, HEIGHT);
        List<Line> lines = ladder.getLines();

        assertThat(lines).hasSize(HEIGHT);
        IntStream.range(0, WIDTH)
            .forEach(i -> assertThat(lines.get(i).getPoints()).hasSize(WIDTH - 1));
    }
}