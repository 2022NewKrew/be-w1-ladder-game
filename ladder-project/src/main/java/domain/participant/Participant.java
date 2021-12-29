package domain.participant;

public class Participant {

    private final int participantNumber;

    public Participant(int participantNumber) {
        checkParticipantNumber(participantNumber);
        this.participantNumber = participantNumber;
    }

    public int howManyParticipant() {
        return participantNumber;
    }

    private void checkParticipantNumber(int number) {
        if (number <= 1) {
            throw new IllegalArgumentException("참가자가 1명이 되어서는 안됩니다");
        }
    }
}
