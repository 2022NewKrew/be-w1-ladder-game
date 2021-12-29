package domain;

import domain.participant.Participant;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParticipantTest {

    @Test
    void howManyParticipantTest() {
        //given
        int number = 3;
        Participant participant = new Participant(number);

        //when
        int result = participant.howManyParticipant();

        //then
        assertEquals(number, result);
    }

    @Test
    void checkParticipantNumber() {
        //given, when
        int number = 1;

        //then
        assertThrows(IllegalArgumentException.class, () -> new Participant(number));
    }
}