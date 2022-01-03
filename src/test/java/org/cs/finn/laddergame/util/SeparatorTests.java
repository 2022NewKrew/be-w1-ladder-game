package org.cs.finn.laddergame.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SeparatorTests {

    @ParameterizedTest
    @CsvSource(value = {";,", "029,394;"}, delimiter = ';')
    @DisplayName("null이 전달되면 예외를 발생시킨다")
    public void testNullParameter(String str, String regex) {
        // then
        assertThatThrownBy(() -> Separator.splitString(str, regex))
                .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"test1,test2;,;test1,test2", "test1   , test2  ,test3;,;test1,test2,test3"}, delimiter = ';')
    @DisplayName("정상요청을 처리한다")
    public void testSuccessParameter(String str, String regex, String expected) {
        // then
        assertThat(Separator.splitString(str, regex))
                .isEqualTo(expected.split(","));

    }
}
