package ladder.domain;

import java.util.Objects;

public class Result {

    private final String name;

    public Result(String name) {
        this.name = name;
    }

    public String getNameWithGap(int ladderWidth, int nameGap) {
        if (Objects.equals(name, "꽝")) {
            return String.format("%" + (ladderWidth - 1 + nameGap) + "s", name);
        }
        return String.format("%" + (ladderWidth + nameGap) + "s", name);
    }

    public String getName() {
        return name;
    }
}