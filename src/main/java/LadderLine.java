import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderLine {

    private final Random random;

    private final String BAR = "|";
    private final String CONNECT = "-----";
    private final String BLANK = "     ";

    private List<Boolean> line;

    public LadderLine(Random random) {
        this.random = random;
    }

    public void makeLine(int width) {
        line = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            line.add(decideNextConnection(i));
        }
    }

    public String shapeLine() {
        StringBuilder stringBuilder = new StringBuilder("    ");
        for (boolean connected : line) {
            stringBuilder.append(BAR)
                .append(connected ? CONNECT : BLANK);
        }

        return stringBuilder.append(BAR).toString();
    }

    private boolean decideNextConnection(int idx) {
        if (idx > 0 && line.get(idx - 1) == true) {
            return false;
        }
        return random.nextBoolean();
    }
}
