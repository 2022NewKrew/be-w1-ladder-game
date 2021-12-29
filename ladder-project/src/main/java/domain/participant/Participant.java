package domain.participant;

import java.util.List;
import java.util.stream.Collectors;

public class Participant {

    private final List<Name> nameList;

    public Participant(List<String> nameList) {
        checkParticipantNumber(nameList.size());
        this.nameList = nameList.stream()
                .map(Name::new)
                .collect(Collectors.toList());
    }

    public int howManyParticipant() {
        return nameList.size();
    }

    public List<String> getParticipantNameList() {
        return this.nameList.stream()
                .map(Name::getName)
                .collect(Collectors.toList());
    }

    private void checkParticipantNumber(int number) {
        if (number <= 1) {
            throw new IllegalArgumentException("참가자가 1명이 되어서는 안됩니다");
        }
    }
}
