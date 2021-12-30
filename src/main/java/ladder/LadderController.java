package ladder;

import java.util.LinkedHashMap;
import java.util.Map;
import ladder.domain.Ladder;
import ladder.domain.Player;
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

    public Map<String, String> foundResult() {
        Map<String, String> results = new LinkedHashMap<>();
        for (int i = 0; i < players.size(); i++) {
            int resultIndex = ladder.foundResult(i);
            Player player = players.get(i);
            results.put(player.getName(), rewards.getReward(resultIndex));
        }
        return results;
    }
}
