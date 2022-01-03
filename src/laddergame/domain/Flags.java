package laddergame.domain;

import java.util.List;

public class Flags {
    List<Flag> flags;

    Flags(List<Flag> flags) {
        this.flags = flags;
    }

    Flag getFlagByIndex(int index) {
        return flags.get(index);
    }
}
