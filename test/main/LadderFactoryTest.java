package main;

import org.junit.Test;

import static org.junit.Assert.*;

public class LadderFactoryTest {

    @Test
    public void generateLadder() {
        Ladder ladder = new Ladder(3,4);
        assertEquals(ladder.getLadderHeight(), new Ladder(3,4).getLadderHeight());
    }
    // 테스트 용도로 만들어봄
}