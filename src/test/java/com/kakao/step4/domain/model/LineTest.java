package com.kakao.step4.domain.model;

import com.kakao.step4.domain.model.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    @DisplayName("라인 생성 시 겹치는 라인이 없는지 확인")
    @Test
    public void lineCreateTest() {
        int countOfPeople = 3;
        List<String> availLines = Arrays.asList(
                "     |     |     |\n",
                "     |-----|     |\n",
                "     |     |-----|\n");
        Line line = new Line(countOfPeople);
        assertThat(line.toString()).isIn(availLines);
    }
}