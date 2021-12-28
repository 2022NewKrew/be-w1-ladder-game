package configuration;

public class LadderGameConfiguration {

    // 게임의 각각 설정은 게임 시작 후 변경 불가능하다고 가정. 생성자로만 입력받게함.
    private final int numberOfMan;

    private final int maxHeightOfLadder;

    public LadderGameConfiguration(int numberOfMan, int maxHeightOfLadder) {
        this.numberOfMan = numberOfMan;
        this.maxHeightOfLadder = maxHeightOfLadder;
    }

    public int getNumberOfMan() {
        return numberOfMan;
    }

    public int getMaxHeightOfLadder() {
        return maxHeightOfLadder;
    }
}
