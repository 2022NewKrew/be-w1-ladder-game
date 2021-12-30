package com.kakao.step4.domain;

import com.kakao.step4.exceptions.EmptyInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderGameTest {
    @DisplayName("잘못된 사다리 높이 값 입력 확인")
    @Test
    public void ladderGameWrongHeightTest() {
        String input = "aaa,bbb,ccc\n-1\n";
        LadderGame ladderGame = new LadderGame();
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);

        assertThrows(NumberFormatException.class, ladderGame::start);
    }
}