package ladder;

import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.dto.ResultDto;

public class LadderController {

    private final Ladder ladder;
    private final Players players;

    public LadderController(String[] playerNames, int ladderHeight) {
        players = Players.valueOf(playerNames);
        ladder = Ladder.valueOf(playerNames.length, ladderHeight);
    }

    public ResultDto result() {
        return ResultDto.valueOf(ladder, players);
    }
}
