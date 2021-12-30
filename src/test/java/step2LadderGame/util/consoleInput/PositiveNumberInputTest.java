package step2LadderGame.util.consoleInput;

import step2LadderGame.exception.ladderException.ConsoleInputCountExceededException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class PositiveNumberInputTest {

    @Test
    @DisplayName("문자열을 양의 정수로 성공적으로 변환하는 테스트")
    void read() {
        // given
        final int input = 345;

        final InputStream in = new ByteArrayInputStream(String.valueOf(input).getBytes());
        System.setIn(in);

        final PositiveNumberInputConsole positiveNumberInput = new PositiveNumberInputConsole();

        // when
        final int positiveNum = positiveNumberInput.read("test");

        // then
        assertEquals(input, positiveNum);
    }

    @Test
    @DisplayName("3번이상 입력 실패시 에러를 반환하는 테스트")
    void readThrowException() {
        // given
        final String notIntegerStr = "abc\nabc\nabc";

        final InputStream in = new ByteArrayInputStream(notIntegerStr.getBytes());
        System.setIn(in);

        final PositiveNumberInputConsole positiveNumberInput = new PositiveNumberInputConsole();

        // when then
        assertThrows(ConsoleInputCountExceededException.class, () -> positiveNumberInput.read("test"));
    }
}