package ladder;

import java.util.LinkedHashMap;
import java.util.Map;
import ladder.domain.Ladder;
import ladder.domain.Player;
import ladder.domain.Players;
import ladder.domain.Rewards;
import ladder.dto.InfoDto;
import ladder.dto.PlayerDto;

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

    public Map<PlayerDto, String> foundResult() {
        Map<PlayerDto, String> results = new LinkedHashMap<>();
        for (int i = 0; i < players.size(); i++) {
            int resultIndex = ladder.foundResult(i);
            Player player = players.get(i);
            results.put(PlayerDto.valueOf(player), rewards.getReward(resultIndex));
        }
        return results;
    }

    public PlayerDto findPlayer(String name) {
        return PlayerDto.valueOf(players.get(name));
    }
}
