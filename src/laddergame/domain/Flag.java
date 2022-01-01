package laddergame.domain;

public class Flag {
    private static RandomFlag randomFlag = new RandomFlag();
    private Boolean flag;

    Flag() {
    }

    public Boolean getFlag() {
        return flag;
    }

    void makeFlag(Boolean previousFlag) {
        if (previousFlag)
            flag = false;

        flag = randomFlag.getRandomFlag();
    }
}
