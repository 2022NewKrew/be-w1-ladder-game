import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {
    private static final String STRIPE = "|";
    private static final String BRIDGE = "-----";
    private static final String SPACE = "     ";

    private final List<Boolean> line;

    Line(int numberOfLegs) {
        line = new ArrayList<>();
        drawLines(numberOfLegs);
    }

    private void drawLines(int width) {
        Random random = new Random();
        IntStream.range(0, width-1).forEach( i -> {
            line.add(!isPrevBridge(i) && random.nextBoolean());
        });
    }

    private boolean isPrevBridge(int idx) {
        if(idx == 0)
            return false;
        return line.get(idx-1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(STRIPE);
        line.forEach(e -> {
            sb.append(e ? BRIDGE : SPACE);
            sb.append(STRIPE);
        });

        return sb.toString();
    }
}
