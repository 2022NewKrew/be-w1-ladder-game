package laddergame.view;

import laddergame.domain.Ladder;
import laddergame.domain.Player;

import java.util.List;

public interface OutputView {
    void printLadderResult(List<Player> playerList, Ladder ladder);
}
