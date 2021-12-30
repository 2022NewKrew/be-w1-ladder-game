package ladder.dto;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.Rewards;

public class RewardsDto {

    private final List<String> rewards;

    public RewardsDto(List<String> rewards) {
        this.rewards = rewards;
    }

    public static RewardsDto rewardsToDto(Rewards rewards) {
        return new RewardsDto(new ArrayList<>(rewards.getRewards()));
    }

    public List<String> getRewards() {
        return rewards;
    }
}
