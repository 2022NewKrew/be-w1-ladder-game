package org.cs.finn.laddergame.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CheckerTests {

    @ParameterizedTest
    @CsvSource({"-2, 1, 3", "2, -1, 3", "2, 1, -3", "1, 2, 3", "2, 3, 1", "4, 2, 3"})
    @DisplayName("0 <= (min, init, max), min <= init <= max를 만족하지 않으면 예외를 발생한다")
    public void testCheckIntMinMaxInit(int init, int min, int max) {
        // then
        assertThatThrownBy(() -> Checker.checkIntMinMaxInit(init, min, max))
                .isInstanceOf(IllegalStateException.class);
    }

    @ParameterizedTest
    @CsvSource({"-2, 1, 3", "2, -1, 3", "2, 1, -3"})
    @DisplayName("0 <= (min, val, max)를 만족하지 않으면 예외를 발생한다")
    public void testCheckIntNegative(int val, int min, int max) {
        // then
        assertThatThrownBy(() -> Checker.checkIntBound(val, min, max))
                .isInstanceOf(IllegalStateException.class);
    }

    @ParameterizedTest
    @CsvSource({"1, 2, 3", "2, 3, 1", "4, 2, 3"})
    @DisplayName("min <= val <= max를 만족하지 않으면 예외를 발생한다")
    public void testCheckIntBound(int val, int min, int max) {
        // then
        assertThatThrownBy(() -> Checker.checkIntBound(val, min, max))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }
}
