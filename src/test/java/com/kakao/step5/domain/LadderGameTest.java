package com.kakao.step5.domain;

import com.kakao.step5.domain.LadderGame;
import com.kakao.step5.exceptions.DifferentQuantityException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {
    @DisplayName("이름과 결과의 개수가 다를 경우 예외 확인")
    @Test
    public void ladderGameWrongHeightTest() {
        String input = "aaa,bbb,ccc\nc,d\n-1\n";
        LadderGame ladderGame = new LadderGame();
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        assertThrows(DifferentQuantityException.class, ladderGame::start);
    }
}