/*
 * @author ed.shim
 */
package ladderGame.view;

import ladderGame.domain.Input;
import java.util.ArrayList;
import java.util.List;

/*
*   사다리 정보와 유저 정보에 대한 필드와
*   사다리를 생성하는 메소드가 모여있는 class 입니다.
*   Input 클래스를 통해 입력을 받아와서 인스턴스를 생성합니다.
* */
public class LadderGame {
    private final List<Line> ladder;
    private final int numberOfPlayers;
    private final int height;
    private final List<String> players;

    public LadderGame(List<String> players, int height) {
        this.players = players;
        this.numberOfPlayers = players.size();
        this.height = height;
        ladder = generateLadder();
    }

    public static final LadderGame getLadderGameInstance() {
        LadderGame instance = new LadderGame(Input.getPlayers(), Input.getHeight());
        Input.closeScanner();
        return instance;
    }

    public final ArrayList<Line> generateLadder() {
        ArrayList<Line> ladder = new ArrayList(height);
        for(int i = 0; i < height; i++) {
            ladder.add(new Line(numberOfPlayers));
        }
        return ladder;
    }

    public final List<Line> getLadder() { return ladder; }

    public final List<String> getPlayers() { return players; }
}