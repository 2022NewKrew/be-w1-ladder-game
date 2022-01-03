package domain.gameResult;

import domain.ladder.Ladder;
import dto.ladderDto.LadderDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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
    @ParameterizedTest
    @MethodSource("legalUsers")
    public void checkLegalUsers(List<String> testLegalUsers) {
        //Give : 올바른 유저 리스트
        //When : LadderGamePrecondition.checkUsers 메소드에 TEST_MAX_LENGTH와 testLegalUsers가 인자로 넘어갔을 때
        //Then
        assertThatCode(() -> GameResultPrecondition.checkUsers(testLegalUsers, TEST_MAX_LENGTH)).doesNotThrowAnyException();
    }

    @DisplayName("올바르지 못한 유저 리스트로 LadderGamePrecondition.checkUsers 메소드를 실행하면 IllegalArgumentException을 던진다.")
    @ParameterizedTest
    @MethodSource("illegalUsers")
    public void checkIllegalUsers(List<String> testIllegalUsers) {
        //Give : 올바르지 못한 유저 리스트
        //When : LadderGamePrecondition.checkUsers 메소드에 TEST_MAX_LENGTH와 testIllegalUsers 인자로 넘어갔을 때
        //Then
        assertThatThrownBy(() -> GameResultPrecondition.checkUsers(testIllegalUsers, TEST_MAX_LENGTH)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 LadderDTO와 Users의 길이로 GameResultPrecondition.checkLadderDto 메서드를 실행하면 예외를 던지지 않는다.")
    @ParameterizedTest
    @MethodSource("legalLadder")
    public void checkLegalDTO(Ladder testLegalLadder) {
        //Give
        final LadderDTO ladderDTO = new LadderDTO(testLegalLadder);
        final int TEST_USER_LENGTH = 6;
        //When : GameResultPrecondition.checkLadderDto 메소드에 ladderDTO, testUserLength 인자로 넘어갔을 때
        //Then
        assertThatCode(() -> GameResultPrecondition.checkLadderDto(ladderDTO, TEST_USER_LENGTH)).doesNotThrowAnyException();
    }

    @DisplayName("올바르지 못한 LadderDTO와 Users의 길이로 GameResultPrecondition.checkLadderDto 메서드를 실행하면 IllegalArgumentException 예외를 던진다.")
    @ParameterizedTest
    @MethodSource("illegalLadder")
    public void checkIllegalDTO(Ladder testIllegalLadder) {
        //Give
        final LadderDTO ladderDTO = new LadderDTO(testIllegalLadder);
        final int TEST_USER_LENGTH = 6;
        //When : GameResultPrecondition.checkLadderDto 메소드에 ladderDTO, TEST_USER_LENGTH 인자로 넘어갔을 때
        //Then
        assertThatThrownBy(() -> GameResultPrecondition.checkLadderDto(ladderDTO, TEST_USER_LENGTH)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 결과값과 올바른 유저값이 주어졌을 때 GameResultPrecondition.checkResults 메서드를 실행하면 예외를 던지지 않는다.")
    @ParameterizedTest
    @MethodSource("legalResults")
    public void checkLegalResult(List<String> testLegalResults, List<String> testLegalUsers) {
        //Give : 올바른 결과 리스트, 올바른 유저 리스트, 글자수 제한
        final int TEST_MAX_LENGTH = 5;
        //When : GameResultPrecondition.checkLadderDto 메소드에 ladderDTO, TEST_EXPECTED_LENGTH 인자로 넘어갔을 때
        //Then
        assertThatCode(() -> GameResultPrecondition.checkResults(testLegalResults, TEST_MAX_LENGTH, testLegalUsers.size())).doesNotThrowAnyException();
    }

    @DisplayName("올바르지 못한 결과값과 올바른 유저값이 주어졌을 때 GameResultPrecondition.checkResults 메서드를 실행하면 IllegalArgumentException 예외를 던진다.")
    @ParameterizedTest
    @MethodSource("illegalResults")
    public void checkIllegalResult(List<String> testIllegalResults, List<String> testLegalUsers) {
        //Give : 올바지 못한 결과 리스트, 올바른 유저 리스트, 글자수 제한
        final int TEST_MAX_LENGTH = 5;
        //When : GameResultPrecondition.checkLadderDto 메소드에 ladderDTO, TEST_EXPECTED_LENGTH 인자로 넘어갔을 때
        //Then
        assertThatThrownBy(() -> GameResultPrecondition.checkResults(testIllegalResults, TEST_MAX_LENGTH, testLegalUsers.size())).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<List<String>> legalUsers() {
        return Stream.of(Arrays.asList("abc", "bcd", "abcd", "abcde", "efg"));
    }

    private static Stream<List<String>> illegalUsers() {
        return Stream.of(Arrays.asList("abcde", "abcdef", "abc", "def", "hij"));
    }

    private static Stream<Arguments> legalResults() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList("abc", "bcd", "abcd", "abcde", "efg"),
                        Arrays.asList("abc", "bcd", "abcd", "abcde", "efg")
                )
        );
    }

    private static Stream<Arguments> illegalResults() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList("abcde", "abcdef", "abc", "def", "hij"),
                        Arrays.asList("abc", "bcd", "abcd", "abcde", "efg")
                )
        );
    }

    private static Stream<Ladder> legalLadder() {
        return Stream.of(new Ladder(TEST_LEGAL_NUBMER_OF_FRAME, TEST_LADDER_HEIGHT));
    }

    private static Stream<Ladder> illegalLadder() {
        return Stream.of(new Ladder(TEST_ILLEGAL_NUMBER_OF_FRAME, TEST_LADDER_HEIGHT));
    }
}
