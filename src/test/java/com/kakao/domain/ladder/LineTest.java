package com.kakao.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;

import com.kakao.util.RandomUtil;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class LineTest {

    private static MockedStatic<RandomUtil> randomUtil;
    private final int WIDTH = 10;

    @BeforeAll
    static void beforeAll() {
        randomUtil = mockStatic(RandomUtil.class);
    }

    @AfterAll
    static void afterAll() {
        randomUtil.close();
    }

    @DisplayName("TRUE 포인트가 연속적으로 그려질 수 없다.")
    @Test
    void drawLine_AllTrue_NoOverlap() {
        // given
        given(RandomUtil.nextBoolean()).willReturn(Boolean.TRUE);

        // when
        Line line = Line.drawLine(WIDTH);
        List<Boolean> points = line.getPoints();

        // then
        assertThat(points).hasSize(WIDTH - 1);
        IntStream.range(0, points.size())
            .filter(i -> i % 2 == 0)
            .forEach(i -> assertThat(points.get(i)).isTrue());
        IntStream.range(0, points.size())
            .filter(i -> i % 2 != 0)
            .forEach(i -> assertThat(points.get(i)).isFalse());
    }

    @DisplayName("FALSE 포인트는 연속적으로 그려질 수 있다.")
    @Test
    void drawLine_AllFalse_Overlap() {
        // given
        given(RandomUtil.nextBoolean()).willReturn(Boolean.FALSE);

        // when
        Line line = Line.drawLine(WIDTH);
        List<Boolean> points = line.getPoints();

        // then
        assertThat(points).hasSize(WIDTH - 1);
        IntStream.range(0, points.size()).forEach(i -> assertThat(points.get(i)).isFalse());
    }
}