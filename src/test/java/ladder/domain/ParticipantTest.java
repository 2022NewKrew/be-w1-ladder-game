package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParticipantTest {

    @DisplayName("참가자 이름 가운데 정렬 테스트")
    @Test
    void getNameCenterAlignedTest() {
        // given
        String name = "ab";
        Participant participant = new Participant(name);

        // when
        String centeredName = participant.getNameCenterAligned();

        // then
        assertEquals(" ab  ", centeredName);
    }

    @DisplayName("참가자 이름이 5글자 초과했을 때는 최대 5글자까지만 노출된다.")
    @Test
    void exceedMaxLengthTest() {
        // given
        String name = "abcdef";
        Participant participant = new Participant(name);

        // when
        String result = participant.getNameCenterAligned();

        // then
        assertEquals("abcde", result);
    }
}