package preconditions;

import controller.LadderGamePrecondition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("LadderGame 검증")
@Nested
class LadderGamePreconditionTest {
    private static final int TEST_MAX_LENGTH = 5;

    @DisplayName("올바른 유저들이 담긴 리스트일때는 예외를 던지지 않음")
    @ParameterizedTest
    @MethodSource("legalUsers")
    public void checkLegalUsers(List<String> testLegalUsers) {
        assertThatCode(() -> LadderGamePrecondition.checkUsers(testLegalUsers, TEST_MAX_LENGTH)).doesNotThrowAnyException();
    }

    @DisplayName("올바르지 못한 유저가 담긴 리스트일 때 IllegalArgumentException을 던짐")
    @ParameterizedTest
    @MethodSource("illegalUsers")
    public void checkIllegalUsers(List<String> testIllegalUsers) {
        assertThatThrownBy(() -> LadderGamePrecondition.checkUsers(testIllegalUsers, TEST_MAX_LENGTH)).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<List<String>> legalUsers() {
        return Stream.of(Arrays.asList("abc", "bcd", "abcd", "abcde", "efg"));
    }

    private static Stream<List<String>> illegalUsers() {
        return Stream.of(Arrays.asList("abcde", "abcdef", "abc", "def", "hij"));
    }
}
