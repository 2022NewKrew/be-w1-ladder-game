import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CrossLine {
    private static final Random RANDOM = new Random();
    private static final String VERTICAL_BAR = "|";
    private static final String CROSS_BAR = "-----";
    private static final String BLANK = "     ";

    private List<Boolean> bars;

    public CrossLine(int size) {
        bars = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            bars.add(generateRandomBar(i));
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(VERTICAL_BAR);

        for (int i = 0; i < bars.size(); i++) {
            sb.append((bars.get(i)) ? CROSS_BAR : BLANK);
            sb.append(VERTICAL_BAR);
        }

        return sb.toString();
    }

    public boolean generateRandomBar(int x) {
        if (x - 1 >= 0 && bars.get(x - 1)) {
            return false;
        }

        return RANDOM.nextBoolean();
    }

    public List<Boolean> getBars() {
        return bars;
    }
}
