package Step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {

    private final int people;
    private final int height;
    private final List<StringBuilder> ladder = new ArrayList<>();

    public Ladder(int people, int height) {
        this.people = people;
        this.height = height;
        makeLadder();
    }

    public void printLadder() {
        for(StringBuilder s : ladder) {
            System.out.println(s);
        }
    }

    private void makeLadder() {
        for(int i=0; i<height; i++) {
            ladder.add(makeWidth());
        }
    }

    private StringBuilder makeWidth() {
        StringBuilder sb = new StringBuilder("|");
        Random random = new Random();

        for(int j=0; j<people-1; j++) {
            sb.append(random.nextBoolean()  ? '-' : ' ');
            sb.append('|');
        }
        return sb;
    }
}
