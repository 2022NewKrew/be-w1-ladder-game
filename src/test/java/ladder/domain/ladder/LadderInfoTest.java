package ladder.domain.ladder;

import ladder.exception.LadderException;
import ladder.exception.LadderException.ErrorCode;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static ladder.exception.LadderException.ErrorCode.*;
import static org.junit.jupiter.api.Assertions.*;

class LadderInfoTest {

    private static final List<String> PARTICIPANTS = List.of("a", "bb", "ccc", "dddd", "eeeee");
    private static final List<String> RESULTS = List.of("1", "2", "3", "4", "5");
    private static final int HEIGHT = 5;

    @Test
    void 참여자의_이름이_공백인경우_예외발생() {
        //given
        List<String> participantsWithEmptyNames = List.of("aaa", "", "bb", "c", "ddd");

        //when
        ErrorCode errorCode = assertThrows(
                LadderException.class, () -> new LadderInfo(participantsWithEmptyNames, RESULTS, HEIGHT)
        ).getErrorCode();

        //then
        assertEquals(errorCode, EMPTY_PARTICIPANT_NAME);
    }

    @Test
    void 참여자의_이름이_최대_글자를_초과하는경우_예외발생() {
        //given
        List<String> participantsWithExceedMaxNameLength = List.of("a", "exceedName", "bb", "c", "ddd");

        //when
        ErrorCode errorCode = assertThrows(
                LadderException.class, () -> new LadderInfo(participantsWithExceedMaxNameLength, RESULTS, HEIGHT)
        ).getErrorCode();

        //then
        assertEquals(errorCode, EXCEED_MAX_PARTICIPANT_NAME);
    }

    @Test
    void 참여자가_없는경우_예외발생() {
        //given
        List<String> emptyParticipants = Collections.emptyList();

        //when
        ErrorCode errorCode = assertThrows(
                LadderException.class, () -> new LadderInfo(emptyParticipants, RESULTS, HEIGHT)
        ).getErrorCode();

        //then
        assertEquals(errorCode, EMPTY_PARTICIPANTS);
    }

    @Test
    void 사다리의_높이가_1보다_작은경우_예외발생() {
        //given
        int invalidHeight = 0;

        //when
        ErrorCode errorCode = assertThrows(
                LadderException.class, () -> new LadderInfo(PARTICIPANTS, RESULTS, invalidHeight)
        ).getErrorCode();

        //then
        assertEquals(errorCode, INVALID_HEIGHT);
    }

    @Test
    void 참여자와_결과의_개수가_맞지_않는경우_예외발생() {
        //given
        List<String> threeParticipants = List.of("a", "bb", "ccc");
        List<String> fourResults = List.of("1", "2", "3", "4");

        //when
        ErrorCode errorCode = assertThrows(
                LadderException.class, () -> new LadderInfo(threeParticipants, fourResults, HEIGHT)
        ).getErrorCode();

        //then
        assertEquals(errorCode, MISMATCH_PARTICIPANTS_AND_RESULT);
    }

    @Test
    void 결과의_내용이_공백인경우_예외발생() {
        //given
        List<String> resultsWithEmptyName = List.of("1", "", "3", "4", "5");

        //when
        ErrorCode errorCode = assertThrows(
                LadderException.class, () -> new LadderInfo(PARTICIPANTS, resultsWithEmptyName, HEIGHT)
        ).getErrorCode();

        //then
        assertEquals(errorCode, EMPTY_RESULT_NAME);
    }

    @Test
    void 결과의_내용이_최대_글자를_초과하는경우_예외발생() {
        //given
        List<String> resultsWithExceedMaxNameLength = List.of("1", "exceedName", "3", "4", "5");

        //when
        ErrorCode errorCode = assertThrows(
                LadderException.class, () -> new LadderInfo(PARTICIPANTS, resultsWithExceedMaxNameLength, HEIGHT)
        ).getErrorCode();

        //then
        assertEquals(errorCode, EXCEED_MAX_RESULT_NAME);
    }

}