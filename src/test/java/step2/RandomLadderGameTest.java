package step2;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class RandomLadderGameTest {
    @Test
    public void test(){
        final String inputStr = "avsd \n 10";

        InputStream in = new ByteArrayInputStream(inputStr.getBytes());
        System.setIn(in);

        RandomLadderGame randomLadderGame = new RandomLadderGame();
        randomLadderGame.start();
    }

}