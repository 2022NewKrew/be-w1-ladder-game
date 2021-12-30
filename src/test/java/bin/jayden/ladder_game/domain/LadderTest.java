package bin.jayden.ladder_game.domain;

import bin.jayden.ladder_game.exception.InvalidLadderHeightException;
import bin.jayden.ladder_game.exception.InvalidNameSizeException;
import bin.jayden.ladder_game.exception.InvalidParticipantsSizeException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderTest {
    @Test
    public void wrongParticipantSizeTest() {
        //given
        String[] participants = {"one"};
        int height = 5;

        //when
        final InvalidParticipantsSizeException exception = assertThrows(InvalidParticipantsSizeException.class, () -> new LadderInfo(participants, height));

        //then
        assertThat(exception.getMessage()).isEqualTo(String.format("잘못된 크기의 참가자 수 입니다. (최소 : %d, 최대 : %d)", Constants.MIN_PARTICIPANT_SIZE, Constants.MAX_PARTICIPANT_SIZE));
    }

    @Test
    public void wrongParticipantNameSizeTest() {
        //given
        String[] participants = {"longlongName", "two"};
        int height = 5;

        //when
        final InvalidNameSizeException exception = assertThrows(InvalidNameSizeException.class, () -> new LadderInfo(participants, height));

        //then
        assertThat(exception.getMessage()).isEqualTo(String.format("잘못된 크기의 이름을 가진 참가자가 존재합니다. (최소 : %d, 최대 : %d)", Constants.MIN_NAME_SIZE, Constants.MAX_NAME_SIZE));
    }

    @Test
    public void wrongLadderHeightTest() {
        //given
        String[] participants = {"one", "two"};
        int height = -1;

        //when
        final InvalidLadderHeightException exception = assertThrows(InvalidLadderHeightException.class, () -> new LadderInfo(participants, height));

        //then
        assertThat(exception.getMessage()).isEqualTo(String.format("잘못된 크기의 사다리 높이입니다. (최소 : %d, 최대 : %d)", Constants.MIN_LADDER_HEIGHT, Constants.MAX_LADDER_HEIGHT));
    }

    @Test
    public void makeLadderTest() {
        //given
        int width = 5;
        int height = 5;

        //when
        Ladder ladder = new Ladder(width, height);

        //then
        String toString = ladder.getLadderRows().toString();
        assertThat(toString).doesNotContain(Constants.CONSECUTIVE_VALUE);
    }

}