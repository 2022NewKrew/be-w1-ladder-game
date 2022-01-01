package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class Flags {
    List<Flag> flags = new ArrayList<Flag>();

    Flags() {
    }

    Flag getFlagByIndex(int index) {
        return flags.get(index);
    }

    void makeFlags(int count) {
        Boolean previousFlag = false;
        for (int i = 0; i < count; i++) {
            Flag currentFlag = new Flag();
            currentFlag.makeFlag(previousFlag);
            flags.add(currentFlag);
            previousFlag = currentFlag.getFlag();
        }
    }
}
