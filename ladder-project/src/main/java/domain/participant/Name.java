package domain.participant;

public class Name {

    private final String participantName;

    public Name(String participantName) {
        checkNameLength(participantName);
        this.participantName = participantName;
    }

    public String getName() {
        return participantName;
    }

    private void checkNameLength(String participantName) {
        if (participantName.length() > 5) {
            throw new IllegalArgumentException("이름이 5글자를 넘을 수 없습니다");
        }
    }
}
