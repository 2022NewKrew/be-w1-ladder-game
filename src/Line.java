import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<Character> line;

    Line(int numberOfLegs) {
        line = new ArrayList<>();
        drawLines(numberOfLegs * 2 - 1);
    }

    private void drawLines(int width) {
        for(int i = 0; i < width; i++) {
            line.add(getLine(i));
        }
    }

    private Character getLine(int currentIndex) {
        if(currentIndex % 2 == 0) {
            return '|';
        }
        return randomBridge();
    }

    private Character randomBridge() {
        Random random = new Random();
        return random.nextBoolean() ? '-' : ' ';
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        line.forEach(sb::append);

        return sb.toString();
    }
}
