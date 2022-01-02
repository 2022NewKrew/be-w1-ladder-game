package ladder.view;

import ladder.domain.LadderGame;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;

class InputViewTest {
    private InputView inputView;

    private static InputStream stdin;

    @BeforeAll
    static void setUpAll() {
        stdin = System.in;
    }

    @AfterAll
    static void teardownAll() {
        System.setIn(stdin);
    }

    /**
     * {@link LadderGame#PLAYER_NAME_LENGTH_LIMIT}를 넘는 길이 입력이 들어왔을 때
     * {@link IllegalArgumentException} 던져지는지 확인
     */
    @Test
    void getPlayersFromScanner() {
        String input = "aaaaaaaaa,bb,cc,dd" + System.lineSeparator();
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        inputView = new InputView();

        assertThatThrownBy(() -> inputView.getPlayersFromScanner("dummy")
        ).isInstanceOf(IllegalArgumentException.class);
    }
}