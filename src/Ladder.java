import java.util.*;

public class Ladder {

    static int participant, height;
    static ArrayList<String[]> ladder = new ArrayList<>();

    public Ladder(int p, int h) {
        participant = p;
        height = h;
        makeLadder();
    }

    static String isPossibleMove() {
        Random random = new Random();
        if (random.nextBoolean()) {
            return "-";
        }
        return " ";
    }

    static void makeLine(int p) {
        String[] line = new String[2*p - 1];
        Arrays.fill(line, "|");
        for (int i = 1; i < 2*p - 1; i += 2) {
            line[i] = isPossibleMove();
        }
        ladder.add(line);
    }

    static void makeLadder() {
        for (int i = 0; i < height; i++) {
            makeLine(participant);
        }
    }

    public void printLadder() {
//        System.out.print(this.ladder);
        for (String[] line : ladder) {
            String stringLine = String.join("", line);
            System.out.println(stringLine);
        }
    }
}