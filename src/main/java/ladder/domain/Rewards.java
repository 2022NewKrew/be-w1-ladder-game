package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rewards {

    private final List<String> rewards;

    public Rewards(List<String> rewards) {
        this.rewards = new ArrayList<>(rewards);
    }

    public static Rewards valueOf(String[] inputRewards) {
        return new Rewards(Arrays.asList(inputRewards));
    }

    public List<String> getRewards() {
        return rewards;
    }
}
