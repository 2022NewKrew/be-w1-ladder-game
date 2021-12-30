package manager;

import model.Ladder;
import model.Player;
import util.CustomScanner;
import view.LadderPrinter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameManager {
    private static final GameManager INSTANCE = new GameManager();

    private static final CustomScanner sc = new CustomScanner();

    private Ladder ladder;

    private GameManager() { }

    public static GameManager getInstance() { return INSTANCE; }

    private void getLadderInput(){
        int numParticipant = sc.nextBoundedInt(2, 10, "참여할 사람은 몇 명인가요?");
        int height = sc.nextBoundedInt(4, 15, "최대 사다리 높이는 몇 개인가요?");

        List<Player> players = getPlayerName(numParticipant);

        ladder = new Ladder(numParticipant, height, players);
    }

    private List<Player> getPlayerName(int numParticipant) {
        List<String> playerName = sc.nextCommaSeperatedString(numParticipant, 5, "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return playerName.stream().map(name -> new Player(name)).collect(Collectors.toList());
    }

    public void run(){
        getLadderInput();
        LadderPrinter.getInstance().displayLadder(ladder);
    }
}