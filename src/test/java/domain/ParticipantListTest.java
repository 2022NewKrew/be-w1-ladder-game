package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ParticipantListTest {

    @Test
    void getParticipantOrder() {
        ArrayList<Participant> participantListTmp = new ArrayList<>();
        participantListTmp.add(new Participant("kim"));
        participantListTmp.add(new Participant("jo"));
        participantListTmp.add(new Participant("park"));

        ParticipantList participantList = new ParticipantList(participantListTmp);
        assertEquals(participantList.getParticipantOrder("jo"),1);
    }
}