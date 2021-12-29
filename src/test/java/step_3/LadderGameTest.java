package step_3;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

class LadderGameTest {
    @Test
    void normal_test_1() throws Exception {
        final String inputString = "jeff,andy,mino\n5";

        try (InputStream inputStream = new ByteArrayInputStream(inputString.getBytes())) {
            System.setIn(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        LadderGame ladderGame = new LadderGame();
        ladderGame.start();
    }

    @Test
    void normal_test_2() throws Exception {
        final String inputString = "jeff,andy,mino,keith,raon\n10";

        try (InputStream inputStream = new ByteArrayInputStream(inputString.getBytes())) {
            System.setIn(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        LadderGame ladderGame = new LadderGame();
        ladderGame.start();
    }

    @Test
    void abnormal_test_1() throws Exception {
        final String inputString = "andy,mino,austin\n5";

        try (InputStream inputStream = new ByteArrayInputStream(inputString.getBytes())) {
            System.setIn(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        LadderGame ladderGame = new LadderGame();
        ladderGame.start();
    }

    @Test
    void abnormal_test_2() throws Exception {
        final String inputString = "andy,mino,jeff\n0";

        try (InputStream inputStream = new ByteArrayInputStream(inputString.getBytes())) {
            System.setIn(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        LadderGame ladderGame = new LadderGame();
        ladderGame.start();
    }
}