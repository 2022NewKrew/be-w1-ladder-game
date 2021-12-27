package domain;

public class Participant {

    private final int participantNumber;

    public Participant(int participantNumber) {
        this.participantNumber = participantNumber;
    }

    public int howManyParticipant() {
        return participantNumber;
    }


}
