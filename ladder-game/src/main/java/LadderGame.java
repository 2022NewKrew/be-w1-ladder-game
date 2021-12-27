import java.util.List;

public class LadderGame {

    final Ladder ladder;

    public LadderGame(int numberOfPeople, int ladderHeight) throws IllegalArgumentException {
        ladder = new Ladder(numberOfPeople, ladderHeight);
    }

    public void printLadderShape() {
        List<String> ladderShape = ladder.getShape();
        for (String ladderLine : ladderShape) {
            System.out.println(ladderLine);
        }
    }
}
