/*
 * @author ed.shim
 */
package ladderGame.ladder;

import ladderGame.domain.Input;
import ladderGame.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

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
    private final List<String> results;

    private LadderGame(List<String> players, List<String> results, int height) {
        this.players = players;
        this.numberOfPlayers = players.size();
        this.results = results;
        this.height = height;
        ladder = generateLadder();
    }

    public static final LadderGame newInstance() {
        final List<String> inputPlayers = Input.getPlayers();
        final List<String> inputResults = Input.getResult(inputPlayers.size());
        final int height = Input.getHeight();
        //LadderGame instance = new LadderGame(Input.getPlayers(), Input.getResult(), Input.getHeight());
        LadderGame instance = new LadderGame(inputPlayers, inputResults, height);
        return instance;
    }

    public static final LadderGame of(List<String> players, List<String> result, int height) {
        LadderGame instance = new LadderGame(players, result, height);
        return instance;
    }

    public final ArrayList<Line> generateLadder() {
        ArrayList<Line> ladder = new ArrayList(height);
        for(int i = 0; i < height; i++) {
            ladder.add(new Line(numberOfPlayers));
        }
        return ladder;
    }

    public final void start() {
        OutputView.printLadder(players, ladder, results);
        calculateResult();
        while(play()) { }
    }

    public final boolean play() { // 게임 끝나는 경우 return false
        final String selectedPlayer = Input.getSelectedPlayer();
        if(selectedPlayer.equals("춘식이"))
            return false;

        if(selectedPlayer.equals("all")) {
            OutputView.printAllResult(players, results);
            return true;
        }

        try {
            OutputView.printOneResult(results.get(players.indexOf(selectedPlayer)));
        } catch (Exception e) {
            System.out.println("잘못된 입력입니다.");
        }
        return true;
    }

    /*
    *       결과를 계산하는 메소드입니다.
    *       사다리의 마지막 줄부터 역순으로 호출하며 결과를 계산합니다.
    *       만약 발판이 있으면, 해당 발판에 닿아있는 두 곳을 swap 하는 방식으로 결과를 계산합니다.
    * */
    private void calculateResult() {
        ListIterator<Line> iterator = ladder.listIterator(ladder.size());
        while(iterator.hasPrevious()) {
            calculateResultAfterOneLine(iterator.previous());
        }
    }

    private void calculateResultAfterOneLine(Line currentLine) {
        List<Boolean> points = currentLine.getPoints();
        int i = 0;
        for(Boolean exist : points) {
            calculateResultAtOnePoint(exist, i++);
        }
    }

    private void calculateResultAtOnePoint(Boolean exist, int idx) {
        if(exist) swap(idx, idx+1);
    }

    private void swap(int idx1, int idx2) { // 'results' List 내의 두 원소 swap
        String tmp = results.get(idx1);
        results.set(idx1, results.get(idx2));
        results.set(idx2, tmp);
    }

    public final List<Line> getLadder() { return ladder; }
}