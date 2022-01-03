package domain.gameResult;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("GameResult 검증")
@Nested
class GameResultPreconditionTest {

    public static final int TEST_LEGAL_NUBMER_OF_FRAME = 5;
    public static final int TEST_LADDER_HEIGHT = 10;
    public static final int TEST_ILLEGAL_NUMBER_OF_FRAME = 10;
    public static final int TEST_MAX_LENGTH = 5;

    @DisplayName("올바른 유저 리스트로 LadderGamePrecondition.checkUsers 메소드를 실행하면 예외를 던지지 않는다.")
    @Test
    public void checkLegalUsers() {
        //Give : 올바른 유저 리스트
        List<String> testLegalUsers = Arrays.asList("abc", "bcd", "abcd", "abcde", "efg");
        //When : LadderGamePrecondition.checkUsers 메소드에 TEST_MAX_LENGTH와 testLegalUsers가 인자로 넘어갔을 때
        //Then
        assertThatCode(() -> GameResultPrecondition.checkUsers(testLegalUsers, TEST_MAX_LENGTH))
                .doesNotThrowAnyException();
    }

    @DisplayName("올바르지 못한 유저 리스트로 LadderGamePrecondition.checkUsers 메소드를 실행하면 IllegalArgumentException을 던진다.")
    @Test
    public void checkIllegalUsers() {
        //Give : 올바르지 못한 유저 리스트
        List<String> testIllegalUsers = Arrays.asList("abcde", "abcdef", "abc", "def", "hij");
        //When : LadderGamePrecondition.checkUsers 메소드에 TEST_MAX_LENGTH와 testIllegalUsers 인자로 넘어갔을 때
        //Then
        assertThatThrownBy(() -> GameResultPrecondition.checkUsers(testIllegalUsers, TEST_MAX_LENGTH))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 결과값과 올바른 유저값이 주어졌을 때 GameResultPrecondition.checkResults 메서드를 실행하면 예외를 던지지 않는다.")
    @Test
    public void checkLegalResult() {
        List<String> testLegalResults = Arrays.asList("abc", "bcd", "abcd", "abcde", "efg");
        List<String> testLegalUsers = Arrays.asList("abc", "bcd", "abcd", "abcde", "efg");
        //Give : 올바른 결과 리스트, 올바른 유저 리스트, 글자수 제한
        //When : GameResultPrecondition.checkLadderDto 메소드에 ladderDTO, TEST_EXPECTED_LENGTH 인자로 넘어갔을 때
        //Then
        assertThatCode(() -> GameResultPrecondition.checkResults(testLegalResults, TEST_MAX_LENGTH, testLegalUsers.size()))
                .doesNotThrowAnyException();
    }

    @DisplayName("올바르지 못한 결과값과 올바른 유저값이 주어졌을 때 GameResultPrecondition.checkResults 메서드를 실행하면 IllegalArgumentException 예외를 던진다.")
    @Test
    public void checkIllegalResult() {
        //Give : 올바지 못한 결과 리스트, 올바른 유저 리스트, 글자수 제한
        List<String> testIllegalResults = Arrays.asList("abcde", "abcdef", "abc", "def", "hij");
        List<String> testLegalUsers = Arrays.asList("abc", "bcd", "abcd", "abcde", "efg");
        //When : GameResultPrecondition.checkLadderDto 메소드에 ladderDTO, TEST_EXPECTED_LENGTH 인자로 넘어갔을 때
        //Then
        assertThatThrownBy(() -> GameResultPrecondition.checkResults(testIllegalResults, TEST_MAX_LENGTH, testLegalUsers.size()))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
