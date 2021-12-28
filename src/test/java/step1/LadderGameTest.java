package step1;

import org.junit.jupiter.api.Test;
import step1.LadderGame;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class LadderGameTest {

    @Test
    void test() {
        final String inputStr = "5\n10";

        InputStream in = new ByteArrayInputStream(inputStr.getBytes());
        System.setIn(in);

        LadderGame ladderGame = new LadderGame();
        ladderGame.start();
    }
}