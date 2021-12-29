import java.util.*;

public class Ladder {

    private int people;
    private int height;
    private ArrayList<String[]> ladder = new ArrayList<>();

    public Ladder(int p, int h) {
        this.people = p;
        this.height = h;
        this.makeLadder();
    }

    private String selectLadder() {
        Random random = new Random();
        return random.nextBoolean() ? "-" : " ";
    }

    private void makeLine(int p) {
        String[] line = new String[2*p - 1];
        Arrays.fill(line, "|");
        for (int i = 1; i < 2*p - 1; i += 2) {
            line[i] = this.selectLadder();
        }
        this.ladder.add(line);
    }

    private void makeLadder() {
        for (int i = 0; i < this.height; i++) {
            this.makeLine(this.people);
        }
    }

    public void printLadder() {
        for (String[] line : this.ladder) {
            String stringLine = String.join("", line);
            System.out.println(stringLine);
        }
    }
}
