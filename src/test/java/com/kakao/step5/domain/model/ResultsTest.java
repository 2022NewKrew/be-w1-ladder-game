package com.kakao.step5.domain.model;

import com.kakao.step5.exceptions.EmptyInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ResultsTest {
    private static final int NAMES_SIZE = 3;

    @DisplayName("다양한 결과 입력 시 출력 형식 확인")
    @Test
    public void resultPrintFormTest() throws Exception {
        String resultsStr = "3000000,          20, 300";
        Results results = new Results(resultsStr, NAMES_SIZE);
        assertThat(results.toString()).isEqualTo("   30000  20    300 \n");
    }

    @DisplayName("결과 입력에 빈 칸만 입력 시 오류 확인")
    @Test
    public void resultWrongInputTestWithOnlyBlanks() {
        String resultsStr = "        ";
        assertThrows(EmptyInputException.class, () -> new Results(resultsStr, NAMES_SIZE));
    }

    @DisplayName("결과 입력에 ,만 입력 시 오류 확인")
    @Test
    public void resultWrongInputTestWithOnlyCommas() {
        String resultsStr = ",,,,,";
        assertThrows(EmptyInputException.class, () -> new Results(resultsStr, NAMES_SIZE));
    }
}