package com.kakao.step4.domain.model;

import com.kakao.step4.domain.model.Names;
import com.kakao.step4.exceptions.DuplicatedInputException;
import com.kakao.step4.exceptions.EmptyInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NamesTest {
    @DisplayName("다양한 이름 입력 시 출력 형식 확인")
    @Test
    public void namePrintFormTest() throws Exception {
        String namesStr = "a,  bb, ccc,              dddd, eeeee,fffffffffffff";
        Names names = new Names(namesStr);
        assertThat(names.toString()).isEqualTo("     a    bb    ccc  dddd  eeeee fffff\n");
    }

    @DisplayName("이름 입력에 빈 칸만 입력 시 오류 확인")
    @Test
    public void nameWrongInputTestWithOnlyBlanks() {
        String namesStr = "        ";
        assertThrows(EmptyInputException.class, () -> new Names(namesStr));
    }

    @DisplayName("이름 입력에 ,만 입력 시 오류 확인")
    @Test
    public void nameWrongInputTestWithOnlyCommas() {
        String namesStr = ",,,,,";
        assertThrows(EmptyInputException.class, () -> new Names(namesStr));
    }

    @DisplayName("이름 중복 입력 시 오류 확인")
    @Test
    public void nameWrongInputTestWithDuplicatedNames() {
        String namesStr = "aaaaa,aaaaaaa";
        assertThrows(DuplicatedInputException.class, () -> new Names(namesStr));
    }
}