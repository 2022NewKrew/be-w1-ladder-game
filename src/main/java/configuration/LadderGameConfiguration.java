package configuration;

public class LadderGameConfiguration {

    // 게임의 각각 설정은 게임 시작 후 변경 불가능하다고 가정. 생성자로만 입력받게함.
    private final PeopleCount peopleCount;

    private final LadderHeight maxLadderHeight;

    public LadderGameConfiguration(PeopleCount peopleCount, LadderHeight ladderHeight) {
        this.peopleCount = peopleCount;
        this.maxLadderHeight = ladderHeight;
    }

    public PeopleCount getPeopleCount() {
        return peopleCount;
    }

    public LadderHeight getMaxLadderHeight() {
        return maxLadderHeight;
    }
}
