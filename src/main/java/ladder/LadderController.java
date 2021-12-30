package ladder;

import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.domain.Rewards;
import ladder.dto.InfoDto;

public class LadderController {

    private final Ladder ladder;
    private final Players players;
    private final Rewards rewards;

    public LadderController(String[] playerNames, String[] inputRewards, int ladderHeight) {
        players = Players.valueOf(playerNames);
        ladder = Ladder.valueOf(playerNames.length, ladderHeight);
        rewards = Rewards.valueOf(inputRewards);
    }

    public InfoDto info() {
        return InfoDto.valueOf(ladder, players, rewards);
    }
}
