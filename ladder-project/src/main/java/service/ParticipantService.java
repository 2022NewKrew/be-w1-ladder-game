package service;

import domain.participant.Name;
import domain.participant.Participant;

import java.util.List;
import java.util.stream.Collectors;

public class ParticipantService {

    private final Participant participant;

    public ParticipantService(Participant participant) {
        this.participant = participant;
    }

    public List<String> getParticipantNameList() {
        return participant.getParticipantNameList().stream()
                .map(Name::getName)
                .collect(Collectors.toList());
    }

    public int getParticipantNumber() {
        return participant.howManyParticipant();
    }
}
