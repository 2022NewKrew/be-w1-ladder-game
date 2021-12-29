package domain.participant;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParticipantTest {

    @Test
    void howManyParticipantTest() {
        //given
        List<String> nameList = Arrays.asList("edwar", "baek", "peach");
        Participant participant = new Participant(nameList);

        //when
        int result = participant.howManyParticipant();

        //then
        assertEquals(nameList.size(), result);
    }

    @Test
    void checkParticipantNumber() {
        //given, when
        List<String> nameList = Collections.singletonList("edwar");

        //then
        assertThrows(IllegalArgumentException.class, () -> new Participant(nameList));
    }

    @Test
    void getParticipantNameList() {
        //given
        List<String> nameList = Arrays.asList("edwar", "baek", "peach");
        Participant participant = new Participant(nameList);

        //when
        List<String> result = participant.getParticipantNameList();

        //then
        assertEquals(nameList.size(), result.size());
    }
}