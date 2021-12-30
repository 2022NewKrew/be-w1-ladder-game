package domain.participant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParticipantTest {

    Participant participantTest;
    List<String> nameList = Arrays.asList("edwar", "baek", "peach");

    @BeforeEach
    void init() {
        participantTest = new Participant(nameList);
    }

    @Test
    @DisplayName("참가자의 수를 제대로 가져오는지 확인하는 테스트")
    void howManyParticipantTest() {
        //given

        //when
        int result = this.participantTest.howManyParticipant();

        //then
        assertEquals(nameList.size(), result);
    }

    @Test
    @DisplayName("한명이 입력되었을 경우에 오류 발생 확인하는 테스트")
    void checkParticipantNumber() {
        //given, when
        List<String> nameList = Collections.singletonList("edwar");

        //then
        assertThrows(IllegalArgumentException.class, () -> new Participant(nameList));
    }

    @Test
    @DisplayName("사람의 이름 목록을 제대로 가져오는지 테스트")
    void getParticipantNameList() {
        //when
        List<String> result = this.participantTest.getParticipantNameList();

        //then
        assertEquals(nameList.size(), result.size());
    }
}