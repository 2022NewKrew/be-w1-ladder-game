package com.yapark97.laddergame.ladder.domain.row;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParticipantsRowTest {
    @DisplayName("참가자 이름 출력 시 최대 5글자를 정확히 출력하는지?")
    @Test
    void participantsNameTest() {
        // given
        List<String> participants = Arrays.asList("a", "ab", "abc", "abcd", "abcde", "abcdef");
        // when
        ParticipantsRow participantsRow = new ParticipantsRow(participants);
        // then
        String expectedResult = "  a    ab    abc  abcd  abcde abcde";
        assertEquals(participantsRow.getSimpleOutput(5), expectedResult);
    }
}