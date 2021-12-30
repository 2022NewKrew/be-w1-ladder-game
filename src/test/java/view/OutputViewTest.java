package view;

import domain.Ladder;
import domain.Participant;
import domain.ParticipantList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    @Test
    void showParticipants() {


        Ladder ladder = new Ladder(5,5);
        ArrayList<Participant> participants = new ArrayList<>(
                Arrays.asList(new Participant("kim"),
                        new Participant("jo"),
                        new Participant("park"),
                        new Participant("jeong"),
                        new Participant("k")));

        ParticipantList participantList = new ParticipantList(participants);
        OutputView outputView = new OutputView(ladder, participantList);
        assertEquals(outputView.showParticipants(), " kim   jo   park  jeong   k         ");
    }
}