package domain;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Rewards {
    static final String MISMATCH_BETWEEN_REWARD_PEOPLE_EXCEPTION_MESSAGE = "사람수와 보상의 수의 갯수가 맞지 않습니다.";

    private final List<Reward> rewards;

    public Rewards(List<String> rewardStrings, int numberOfPeople) {
        validate(rewardStrings, numberOfPeople);
        this.rewards = rewardStrings.stream()
                .map(Reward::new)
                .collect(toList());
    }

    private static void validate(List<String> rewardStrings, int numberOfPeople){
        if(rewardStrings.size() != numberOfPeople){
            throw new IllegalArgumentException(MISMATCH_BETWEEN_REWARD_PEOPLE_EXCEPTION_MESSAGE);
        }
    }

    public Reward getReward(int index){
        return new Reward(this.rewards.get(index));
    }

    @Override
    public String toString() {
        return rewards.stream()
                .map(reward -> String.format("%6s", reward.toString()))
                .reduce("", String::concat);
    }
}
