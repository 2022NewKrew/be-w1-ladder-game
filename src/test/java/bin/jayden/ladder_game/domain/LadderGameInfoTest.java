package bin.jayden.ladder_game.domain;

import bin.jayden.ladder_game.exception.InvalidLadderHeightException;
import bin.jayden.ladder_game.exception.InvalidNameSizeException;
import bin.jayden.ladder_game.exception.InvalidParticipantsSizeException;
import bin.jayden.ladder_game.exception.InvalidResultSizeException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderGameInfoTest {
    @Test
    public void wrongParticipantSizeTest() {
        //given
        String[] participants = {"one"};
        String[] result = {"1000", "2000"};
        int height = 5;

        //when
        final InvalidParticipantsSizeException exception = assertThrows(InvalidParticipantsSizeException.class, () -> new LadderGameInfo(participants, result, height));

        //then
        assertThat(exception.getMessage()).isEqualTo(String.format("잘못된 크기의 참가자 수 입니다. (최소 : %d, 최대 : %d)", Constants.MIN_PARTICIPANT_SIZE, Constants.MAX_PARTICIPANT_SIZE));
    }

    @Test
    public void wrongParticipantNameSizeTest() {
        //given
        String[] participants = {"longlongName", "two"};
        String[] result = {"1000", "2000"};
        int height = 5;

        //when
        final InvalidNameSizeException exception = assertThrows(InvalidNameSizeException.class, () -> new LadderGameInfo(participants, result, height));

        //then
        assertThat(exception.getMessage()).isEqualTo(String.format("잘못된 크기의 이름을 가진 참가자가 존재합니다. (최소 : %d, 최대 : %d)", Constants.MIN_NAME_SIZE, Constants.MAX_NAME_SIZE));
    }

    @Test
    public void wrongResultsSizeTest() {
        //given
        String[] participants = {"one", "two"};
        String[] result = {"1000", "2000", "3000"};
        int height = 5;

        //when
        final InvalidResultSizeException exception = assertThrows(InvalidResultSizeException.class, () -> new LadderGameInfo(participants, result, height));

        //then
        assertThat(exception.getMessage()).isEqualTo("참가자 수와 결과의 개수가 같지않습니다.");
    }

    @Test
    public void wrongLadderHeightTest() {
        //given
        String[] participants = {"one", "two"};
        String[] result = {"1000", "2000"};
        int height = -1;

        //when
        final InvalidLadderHeightException exception = assertThrows(InvalidLadderHeightException.class, () -> new LadderGameInfo(participants, result, height));

        //then
        assertThat(exception.getMessage()).isEqualTo(String.format("잘못된 크기의 사다리 높이입니다. (최소 : %d, 최대 : %d)", Constants.MIN_LADDER_HEIGHT, Constants.MAX_LADDER_HEIGHT));
    }

    @Test
    public void ladderGameInfoTest() {
        //given
        String[] participants = {"one", "two"};
        String[] result = {"1000", "2000"};
        int height = 5;

        //when
        assertDoesNotThrow(() -> new LadderGameInfo(participants, result, height));
    }
}