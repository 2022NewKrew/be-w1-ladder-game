import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private static final Character STRIPE = '|';
    private static final Character BRIDGE = '-';
    private static final Character SPACE = ' ';

    private final List<Boolean> line;

    Line(int numberOfLegs) {
        line = new ArrayList<>();
        drawLines(numberOfLegs);
    }

    private void drawLines(int width) {
        Random random = new Random();
        for(int i = 0; i < width - 1; i++) {
            line.add(random.nextBoolean());
        }
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
