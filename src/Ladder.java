import java.util.*;

public class Ladder {

    static Random random = new Random();
    private final int participant;
    private final int height;
    private final ArrayList<String[]> ladder = new ArrayList<>();

    public Ladder(int gameParticipant, int ladderHeight) {
        participant = gameParticipant;
        height = ladderHeight;
        makeLadder();
    }

    public String makeBridge() {
        if (random.nextBoolean()) {
            return "-";
        }
        return " ";
    }

    public void makeLine(int p) {
        String[] line = new String[2*p - 1];
        Arrays.fill(line, "|");
        for (int i = 1; i < 2*p - 1; i += 2) {
            line[i] = makeBridge();
        }
        ladder.add(line);
    }

    public void makeLadder() {
        for (int i = 0; i < height; i++) {
            makeLine(participant);
        }
    }

    public void printLadder() {
        for (String[] line : ladder) {
            String stringLine = String.join("", line);
            System.out.println(stringLine);
        }
    }
}