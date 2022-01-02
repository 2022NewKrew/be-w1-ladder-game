package laddergame.domain;

public class Flag {
    private static RandomFlag randomFlag = new RandomFlag();
    private Boolean flag = false;

    Flag() {
    }

    public Boolean getFlag() {
        return flag;
    }

    void makeFlag(Boolean previousFlag) {
        if (!previousFlag)
            flag = randomFlag.getRandomFlag();
    }
}
