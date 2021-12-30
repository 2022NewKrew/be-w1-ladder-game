package main.java.ladder.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("입력 유효성 테스트")
class LadderInputTest {

    @Test
    void 플레이어_이름이_5글자보다_길다면_예외를_던진다() {
        //given
        String input = "longName";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when, then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, LadderInput::new);
        assertEquals("문자열은 최대 5글자입니다.", exception.getMessage());
    }

    @Test
    void 사다리_높이가_1미만_이라면_예외를_던진다() {
        //given
        String input = "rain\n5000\n0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when, then
        assertThrows(IllegalArgumentException.class, LadderInput::new);
    }

    @Test
    void 참여인원과_실행결과_수가_다르면_예외를_던진다() {
        //given
        String input = "rain\n5000,1000\n0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when, then
        assertThrows(IllegalArgumentException.class, LadderInput::new);
    }
}