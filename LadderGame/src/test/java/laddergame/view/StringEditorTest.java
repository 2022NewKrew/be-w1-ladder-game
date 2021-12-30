package laddergame.view;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringEditorTest {
    StringEditor se = new StringEditor();
    String name = "ho";
    int max_len = 5;
    @Test
    // paddingName 메소드가 최대 문자열 길이에 맞게 문자열을 패딩해서 반환하는지 테스트
    void paddingName() {
        assertEquals(max_len, se.paddingName(name, max_len).length());
    }
}