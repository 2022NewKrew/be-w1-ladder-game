import java.util.ArrayList;
import java.util.List;


public class Ladder {

    private final int personNum, ladderHeight;
    private List<Line> ladder = new ArrayList<>();

    public Ladder(int personNum, int ladderHeight) {
        this.personNum = personNum;
        this.ladderHeight = ladderHeight;
        makeLadder(personNum, ladderHeight);
    }

    private void makeLadder(int personNum, int ladderHeight) {
        for (int i = 0; i < ladderHeight; i++) {
            ladder.add(new Line(personNum));
        }
    }

    public void printLadder() {
        for (int i = 0; i < ladderHeight; i++) {
            System.out.println(ladder.get(i));
        }
    }

}
