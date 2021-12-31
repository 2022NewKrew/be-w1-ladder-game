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
        // given
        String[] participants = {"one"};
        String[] result = {"1000", "2000"};
        int height = 5;

        // when
        final InvalidParticipantsSizeException exception = assertThrows(InvalidParticipantsSizeException.class, () -> new LadderGameInfo(participants, result, height));

        // then
        assertThat(exception.getMessage()).isEqualTo(Constants.INVALID_PARTICIPANTS_SIZE_MESSAGE);
    }

    @Test
    public void wrongParticipantNameSizeTest() {
        // given
        String[] participants = {"longlongName", "two"};
        String[] result = {"1000", "2000"};
        int height = 5;

        // when
        final InvalidNameSizeException exception = assertThrows(InvalidNameSizeException.class, () -> new LadderGameInfo(participants, result, height));

        // then
        assertThat(exception.getMessage()).isEqualTo(Constants.INVALID_NAME_SIZE_MESSAGE);
    }

    @Test
    public void wrongResultsSizeTest() {
        // given
        String[] participants = {"one", "two"};
        String[] result = {"1000", "2000", "3000"};
        int height = 5;

        // when
        final InvalidResultSizeException exception = assertThrows(InvalidResultSizeException.class, () -> new LadderGameInfo(participants, result, height));

        // then
        assertThat(exception.getMessage()).isEqualTo(Constants.INVALID_RESULT_SIZE_MESSAGE);
    }

    @Test
    public void wrongLadderHeightTest() {
        // given
        String[] participants = {"one", "two"};
        String[] result = {"1000", "2000"};
        int height = -1;

        // when
        final InvalidLadderHeightException exception = assertThrows(InvalidLadderHeightException.class, () -> new LadderGameInfo(participants, result, height));

        // then
        assertThat(exception.getMessage()).isEqualTo(Constants.INVALID_LADDER_HEIGHT_MESSAGE);
    }

    @Test
    public void ladderGameInfoTest() {
        // given
        String[] participants = {"one", "two"};
        String[] result = {"1000", "2000"};
        int height = 5;

        // when
        assertDoesNotThrow(() -> new LadderGameInfo(participants, result, height));
    }
}