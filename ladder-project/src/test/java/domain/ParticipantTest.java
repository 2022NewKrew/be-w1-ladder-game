package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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


}