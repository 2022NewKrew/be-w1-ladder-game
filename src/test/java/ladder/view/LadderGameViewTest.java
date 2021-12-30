package ladder.view;

import static org.junit.jupiter.api.Assertions.assertThrows;

import ladder.domain.LadderGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LadderGameViewTest {

    LadderGameView ladderGameView;
    LadderGame ladderGame;

    @BeforeEach
    void initTest() {
        ladderGame = new LadderGame();
        ladderGameView = new LadderGameView();
    }

    @Test
    void showGameBoard() {
        assertThrows(NullPointerException.class, () -> ladderGameView.showGameBoard(ladderGame));
    }

    @Test
    void showGameResult() {
        assertThrows(NullPointerException.class,
            () -> ladderGameView.showGameResult(ladderGame, "any"));
    }
}
