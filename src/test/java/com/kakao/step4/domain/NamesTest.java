package com.kakao.step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NamesTest {
    @DisplayName("이름 출력 형식 확인")
    @Test
    public void namePrintFormTest() throws Exception {
        String namesStr = "a,  bb, ccc,              dddd, eeeee,fffffffffffff";
        Names names = new Names(namesStr);
        assertThat(names.toString()).isEqualTo("     a     bb   ccc   dddd eeeee fffff\n");
    }

    @DisplayName("이름 입력 오류 확인")
    @Test
    public void nameWrongInputTest() {
        String namesStr = "        ";
        Exception e = assertThrows(Exception.class, () -> new Names(namesStr));
        assertThat(e.getMessage()).isEqualTo("조건에 맞지 않는 이름이 입력되었습니다.");
    }
}