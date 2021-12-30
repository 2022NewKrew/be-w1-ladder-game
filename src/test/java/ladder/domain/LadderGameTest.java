package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {

    @DisplayName("참가자 이름을 정상적으로 입력하였을 때, 입력한 이름의 개수와 게임 참가자의 수는 같아야 한다.")
    @Test
    void testCreateGame() {
        assertDoesNotThrow(() -> {
            // given
            List<String> names = Arrays.asList("pobi", "honux", "crong", "jk");
            int ladderHeight = 6;
            // when
            LadderGame game = LadderGame.createGame(names, ladderHeight);
            // then
            assertEquals(names.size(), game.getParticipants().size());
        });
    }

    @DisplayName("참가자 이름을 하나만 입력하였을 경우, 에러가 발생해야 한다.")
    @Test
    void testInputOneNameTest() {
        assertThrows(Exception.class, () -> {
            // given
            List<String> names = Arrays.asList("a");
            int ladderHeight = 6;
            // when
            LadderGame game = LadderGame.createGame(names, ladderHeight);
            // then
            assertNotNull(game);
        });
    }

    @DisplayName("참가자의 이름 중 공백이 포함되어 있을 경우, 에러가 발생해야 한다.")
    @Test
    void testInputNameContainsWhiteSpaceName() {
        assertThrows(Exception.class, () -> {
            // given
            List<String> names = Arrays.asList("a", "", "bc");
            int ladderHeight = 6;
            // when
            LadderGame game = LadderGame.createGame(names, ladderHeight);
            // then
            assertNotNull(game);
        });
    }

    @DisplayName("참가자의 이름 중 5글자를 초과한 이름이 포함되어 있을 경우, 에러가 발생해야 한다.")
    @Test
    void testInputNameLengthBiggerThanFive() {
        assertThrows(Exception.class, () -> {
            // given
            List<String> names = Arrays.asList("a", "abcdef");
            int ladderHeight = 6;
            // when
            LadderGame game = LadderGame.createGame(names, ladderHeight);
            // then
            assertNotNull(game);
        });
    }

    @DisplayName("사다리의 높이가 0보다 작거나 같은 경우 에러가 발생해야 한다.")
    @Test
    void testInputHeightSameOrSmallerThanZero() {
        assertThrows(Exception.class, () -> {
            // given
            List<String> names = Arrays.asList("a", "ab", "abc", "abcd", "abcde");
            int ladderHeight = 0;
            // when
            LadderGame game = LadderGame.createGame(names, ladderHeight);
            // then
            assertNotNull(game);
        });
    }

}