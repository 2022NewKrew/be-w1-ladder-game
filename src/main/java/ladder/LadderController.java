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
        validate(playerNames, inputRewards);
        players = Players.valueOf(playerNames);
        ladder = Ladder.valueOf(playerNames.length, ladderHeight);
        rewards = Rewards.valueOf(inputRewards);
    }

    private void validate(String[] playerNames, String[] inputRewards) {
        if (playerNames.length != inputRewards.length) {
            throw new IllegalArgumentException("입력과 출력의 개수가 다릅니다.");
        }
    }

    public InfoDto info() {
        return InfoDto.valueOf(ladder, players, rewards);
    }
}
