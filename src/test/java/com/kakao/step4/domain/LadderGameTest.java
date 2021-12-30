package com.kakao.step4.domain;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {
    @Test
    public void ladderGameWrongHeightTest() {
        String input = "aaa,bbb,ccc\n-1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        Exception e = assertThrows(Exception.class, LadderGame::new);
        assertThat(e.getMessage()).isEqualTo("올바르지 않은 사다리 높이가 입력되었습니다.");
    }
}