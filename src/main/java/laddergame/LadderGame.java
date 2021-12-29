package laddergame;

import laddergame.domain.Ladder;
import laddergame.domain.Player;
import laddergame.view.InputView;
import laddergame.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private final List<Player> playerList;
    private final int ladderHeight;
    private final Ladder ladder;

    public LadderGame(List<Player> playerList, int ladderHeight, Ladder ladder) {
        this.playerList = playerList;
        this.ladderHeight = ladderHeight;
        this.ladder = ladder;
    }

    public static LadderGame of(String[] playerNames, int ladderHeight) {
        List<Player> playerList = new ArrayList<>();
        for (String name : playerNames) {
            playerList.add(Player.from(name));
        }
        Ladder ladder = Ladder.of(playerList.size(), ladderHeight);
        return new LadderGame(playerList, ladderHeight, ladder);
    }

    public static String[] inputPlayerNames(InputView inputView) {
        return inputView.inputPlayerNames();
    }

    public static int inputLadderHeight(InputView inputView) {
        return inputView.inputLadderHeight();
    }

    public void printLadderResult(OutputView outputView) {
        outputView.printLadderResult(playerList, ladder);
    }
}
