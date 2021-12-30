package com.kakao.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MarkTest {

    @DisplayName("TRUE 포인트는 연결됐음을 의미한다.(Mark.ROW)")
    @Test
    void of_True_Row() {
        assertThat(Mark.of(Boolean.TRUE)).isEqualTo(Mark.ROW);
    }

    @DisplayName("FALSE 포인트는 연결되지 않았음을 의미한다.(Mark.BLK)")
    @Test
    void of_False_Col() {
        assertThat(Mark.of(Boolean.FALSE)).isEqualTo(Mark.BLK);
    }
}