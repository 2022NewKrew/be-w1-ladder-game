package com.kakao.ladder.step3.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    // Ladder 클래스의 makeLine 메소드로 line을 만들어 bridge가 연속으로 생성되지 않는지 테스트해본다.
    @Test
    public void bridgeTest() {
        List<String> peoples = Arrays.asList("a", "b", "c", "d", "e");
        List<String> resultList = Arrays.asList("꽝", "꽝", "꽝", "당첨", "꽝");
        Ladder ladder = new Ladder(peoples, resultList, 5);
        Line line;
        boolean beforeBridge, bridge;

        for(int i = 0; i < 10000; i++) {
            line = ladder.makeLine();
            beforeBridge = false;
            for(int j = 0; j < 4; j++) {
                bridge = line.getBridge(j);
                if(beforeBridge)
                    assertFalse(bridge);
                beforeBridge = bridge;
            }
        }

    }
}