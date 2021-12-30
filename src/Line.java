import java.util.ArrayList;

public class Line {
    private static RandomFlag randomFlag = new RandomFlag();
    private ArrayList<Boolean> flags = new ArrayList<Boolean>();

    public Line(int count) {
        makeFlags(count);
    }

    public Boolean getFlag(int index) {
        return flags.get(index);
    }

    private void makeFlags(int count) {
        Boolean previousFlag = false;
        Boolean currentFlag;
        for (int i = 0; i < count; i++) {
            currentFlag = getFlag(previousFlag);
            flags.add(currentFlag);
            previousFlag = currentFlag;
        }
    }

    private Boolean getFlag(Boolean previousFlag) {
        if (previousFlag)
            return false;

        return randomFlag.getRandomFlag();
    }
}