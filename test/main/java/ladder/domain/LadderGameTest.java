package main.java.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("사다리 게임 실행 테스트")
class LadderGameTest {

    @Test
    void 사다리가_끝까지_도착하는지_확인() {
        //given
        final int WIDTH = 5;
        final int HEIGHT = 5;
        LadderGame game = new LadderGame(new Ladder(WIDTH, HEIGHT), List.of("rain", "cloud", "sunny"), List.of("10", "10", "10"));

        //when
        String result = game.getOnePlayerResult("rain");

        //then
        assertEquals("10", result);
    }
}