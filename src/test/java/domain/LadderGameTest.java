package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

class LadderGameTest {
    @Test
    @DisplayName("게임이 정상적으로 진행되는지에 대한 테스트 1")
    void start_1() {
        // given
        final String inputString = "pobi,honux,crong,jk\n꽝,5000,꽝,3000\n5\npobi\nall\n춘식이";

        try (InputStream inputStream = new ByteArrayInputStream(inputString.getBytes())) {
            System.setIn(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        LadderGame ladderGame = new LadderGame();

        // when
        ladderGame.start();
    }

    @Test
    @DisplayName("게임이 정상적으로 진행되는지에 대한 테스트 2")
    void start_2() {
        // given
        final String inputString = "mino,andy,jeff,raon,keith\n꽝,10000,꽝,3000,5000\n10\nraon\njeff\nall\n춘식이";

        try (InputStream inputStream = new ByteArrayInputStream(inputString.getBytes())) {
            System.setIn(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        LadderGame ladderGame = new LadderGame();

        // when
        ladderGame.start();
    }
}