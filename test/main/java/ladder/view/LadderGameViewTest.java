package main.java.ladder.view;

import main.java.ladder.domain.Ladder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("사다리 게임 결과 출력 테스트")
class LadderGameViewTest {

    static final int WIDTH = 5;
    static final int HEIGHT = 5;
    static LadderGameView gameView;

    @BeforeAll
    static void init(){
        gameView = new LadderGameView(new Ladder(WIDTH, HEIGHT), List.of("rain", "cloud", "sunny"), List.of("10", "10", "10"));
    }

    @Test
    void 플레이어_한_명의_결과를_출력() {
        //when
        String result = gameView.printResult("rain");

        //then
        assertEquals("실행 결과\n10\n", result);
    }

    @Test
    void 모든_플레이어의_결과를_출력(){
        //when
        String result = gameView.printResult("all");

        //then
        assertEquals("실행 결과\nrain : 10\ncloud : 10\nsunny : 10\n", result);
    }

    @Test
    void 존재하지_않는_플레이어_이름_입력(){
        //when
        String result = gameView.printResult("snow");

        //then
        assertEquals("실행 결과\n존재하지 않는 플레이어입니다.\n", result);
    }
}