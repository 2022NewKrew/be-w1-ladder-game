package ladder.domain;

import ladder.domain.exception.LadderException;
import ladder.domain.exception.LadderException.ErrorCode;
import ladder.domain.ladder.LadderInfo;
import org.junit.jupiter.api.Test;

import static ladder.domain.exception.LadderException.ErrorCode.*;
import static org.junit.jupiter.api.Assertions.*;

class LadderInfoTest {

    private static final String[] PARTICIPANTS = new String[]{"a", "bb", "ccc", "dddd", "eeeee"};
    private static final int HEIGHT = 5;


    @Test
    void 참여자의_이름이_공백인경우_예외발생() {
        //given
        String[] participantsWithEmptyNames = new String[]{"aaa", "", "bb"};

        //when
        ErrorCode errorCode = assertThrows(
                LadderException.class, () -> new LadderInfo(participantsWithEmptyNames, HEIGHT)
        ).getErrorCode();

        //then
        assertEquals(errorCode, EMPTY_PARTICIPANT_NAME);
    }

    @Test
    void 참여자의_이름이_최대_글자를_초과하는경우_예외발생() {
        //given
        String[] participantsWithExceedMaxNameLength = new String[]{"a", "exceedName", "bb"};

        //when
        ErrorCode errorCode = assertThrows(
                LadderException.class, () -> new LadderInfo(participantsWithExceedMaxNameLength, HEIGHT)
        ).getErrorCode();

        //then
        assertEquals(errorCode, EXCEED_MAX_PARTICIPANT_NAME);
    }

    @Test
    void 참여자가_없는경우_예외발생() {
        //given
        String[] emptyParticipants = new String[]{};

        //when
        ErrorCode errorCode = assertThrows(
                LadderException.class, () -> new LadderInfo(emptyParticipants, HEIGHT)
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
                LadderException.class, () -> new LadderInfo(PARTICIPANTS, invalidHeight)
        ).getErrorCode();

        //then
        assertEquals(errorCode, INVALID_HEIGHT);
    }

}