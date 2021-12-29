package step_2;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {
    @Test
    void normal_test() throws Exception {
        final String inputString = "3\n5";

        try (InputStream inputStream = new ByteArrayInputStream(inputString.getBytes())) {
            System.setIn(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        LadderGame ladderGame = new LadderGame();
        ladderGame.start();
    }

    @Test
    void abnormal_test() throws Exception {
        final String inputString = "300\n-1";

        try (InputStream inputStream = new ByteArrayInputStream(inputString.getBytes())) {
            System.setIn(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        LadderGame ladderGame = new LadderGame();
        ladderGame.start();
    }
}