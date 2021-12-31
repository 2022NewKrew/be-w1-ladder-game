package LadderGame.domain.Ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final int ladderWidth, ladderHeight;
    private final List<Line> ladder;
    private final List<Integer> gameResult;

    public Ladder(int ladderWidth, int ladderHeight) {
        validateLadderHeight(ladderHeight);
        this.ladderWidth = ladderWidth;
        this.ladderHeight = ladderHeight;
        this.ladder = makeLadder();
        this.gameResult = new ArrayList<>();
    }

    private void validateLadderHeight(int ladderHeight){
        if(ladderHeight < 1){
            throw new IllegalArgumentException("사다리 높이는 1 이상이어야 합니다.");
        }
    }

    private List<Line> makeLadder() {
        List<Line> ladder = new ArrayList<>();
        for (int row = 0; row < ladderHeight; row++) {
            Line ladderRow = new Line(ladderWidth);
            ladder.add(ladderRow);
        }
        return ladder;
    }

    public void printLadder() {
        ladder.forEach((this::printLadderRow));
    }

    private void printLadderRow(Line ladderRow){
        System.out.println(ladderRow.toString());
    }

    public List<Line> getLadder() {
        return ladder;
    }

    public void makeGameResult(){
        for (int player = 0; player < ladderWidth; player++){
            gameResult.add(playGame(player));
        }
    }

    private int playGame(int player){
        int nowLocation = player;
        for (int row = 0; row < ladderHeight; row++) {
            List<Integer> connectionPoints = ladder.get(row).getConnectionPoints();
            int nextLadder = connectionPoints.get(nowLocation);
            if(nextLadder != -1) nowLocation = nextLadder;
        }
        return nowLocation;
    }

    public List<Integer> getGameResult() {
        return gameResult;
    }
}
