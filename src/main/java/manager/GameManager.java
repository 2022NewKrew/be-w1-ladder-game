package manager;

import model.Ladder;
import model.Player;
import util.CustomScanner;
import view.LadderPrinter;

import java.util.ArrayList;

public class GameManager {
    private static final GameManager INSTANCE = new GameManager();

    private static final CustomScanner sc = new CustomScanner();

    private Ladder ladder;

    private GameManager() { }

    public static GameManager getInstance() { return INSTANCE; }

    private void getLadderInput(){
        int numParticipant = sc.nextBoundedInt(2, 10, "참여할 사람은 몇 명인가요?");
        int height = sc.nextBoundedInt(4, 15, "최대 사다리 높이는 몇 개인가요?");

        ArrayList<Player> players = getPlayerName(numParticipant);

        ladder = new Ladder(numParticipant, height, players);
    }

    private ArrayList<Player> getPlayerName(int numParticipant) {
        ArrayList<Player> players = new ArrayList<>();
        while(players.size() < numParticipant){
            System.out.println();
            String name = sc.nextCommaSeperatedString(5, (players.size() + 1) + "번 플레이어의 이름을 입력하세요");
            players.add(new Player(name));
        }
        return players;
    }

    public void run(){
        getLadderInput();
        LadderPrinter.getInstance().displayLadder(ladder);
    }
}