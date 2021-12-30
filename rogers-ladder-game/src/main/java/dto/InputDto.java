package dto;

import java.util.Collections;
import java.util.List;

public class InputDto {
    private final List<String> names;
    private final List<String> rewardStrings;
    private final int height;

    public InputDto(List<String> names, List<String> rewardStrings, int height) {
        this.names = names;
        this.rewardStrings = rewardStrings;
        this.height = height;
    }

    public List<String> getNames() {
        return Collections.unmodifiableList(names);
    }

    public List<String> getRewardStrings() {
        return Collections.unmodifiableList(rewardStrings);
    }

    public int getHeight() {
        return height;
    }
}
