package configuration;

public class PeopleCount {

    private final int peopleCount;

    public PeopleCount(int peopleCount) {
        validatePeopleCount(peopleCount);
        this.peopleCount = peopleCount;
    }

    public int getValue() {
        return peopleCount;
    }

    private void validatePeopleCount(int peopleCount) {
        if(peopleCount < 0) {
            throw new IllegalArgumentException("사람수는 양수를 입력해주세요~");
        }
    }
}
