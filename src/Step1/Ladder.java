package Step1;

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
    }

    public void makeLadder() {
        for(int i=0; i<height; i++) {

            StringBuilder sb = new StringBuilder();
            Random random = new Random();

            for(int j=0; j<people-1; j++) {
                sb.append('|');
                if(random.nextBoolean()) {
                    sb.append('-');
                } else {
                    sb.append(' ');

                }
            }

            sb.append('|');
            ladder.add(sb);
        }
    }

    public void printLadder() {
        for(StringBuilder s : ladder) {
            System.out.println(s);
        }
    }
}
