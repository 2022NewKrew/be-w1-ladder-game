package laddergame.domain;

import org.junit.jupiter.api.*;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class LadderFactoryTest {

    private static int width;
    private static int height;
    private static Ladder ladder;

    @BeforeAll
    static void setParameter() {
        width = 7;
        height = 8;
        ladder = LadderFactory.create(width, height);
    }

    @Test
    @DisplayName("Ladder 객체 생성 확인")
    void create() {
        assertThat(ladder.getWidth()).isEqualTo(width);
        assertThat(ladder.getHeight()).isEqualTo(height);
    }

    @Test
    @DisplayName("Lines 객체 생성 확인")
    void createLines() {
        final int MIN_INDEX = 0;
        final int MAX_INDEX = height - 1;
        Line line = new Line(new Flags(new ArrayList<Flag>()));
        for (int i = MIN_INDEX; i <= MAX_INDEX; i++)
            assertThat(ladder.getLineByIndex(i)).hasSameClassAs(line);
    }
}