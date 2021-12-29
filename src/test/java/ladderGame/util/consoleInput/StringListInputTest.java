package ladderGame.util.consoleInput;

import ladderGame.exception.ladderException.ConsoleInputCountExceededException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringListInputTest {

    @Test
    @DisplayName("',' 기준 문자열을 문자 리스트로 성공적으로 변환하는 테스트")
    void read() {
        // given
        final int size = 5;
        final String nameStr = "1,2,3,4,5";

        final InputStream in = new ByteArrayInputStream(nameStr.getBytes());
        System.setIn(in);

        final StringListInputConsole stringListInput = new StringListInputConsole();

        // when
        final List<String> stringList = stringListInput.read("test");

        // then
        assertEquals(size, stringList.size());
    }

    @Test
    @DisplayName("3번이상 5글자 초과 입력시 에러를 반환하는 테스트")
    void readThrowException() {
        // given
        final String noneStr = "aaaaaa\nbbbbbb\ncccccc\n";

        final InputStream in = new ByteArrayInputStream(noneStr.getBytes());
        System.setIn(in);

        final StringListInputConsole stringListInput = new StringListInputConsole();

        // when then
        assertThrows(ConsoleInputCountExceededException.class, () -> stringListInput.read("test"));
    }
}