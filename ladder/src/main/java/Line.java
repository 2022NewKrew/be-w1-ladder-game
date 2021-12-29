import java.util.Random;


public class Line {
    public char[] line;
    public Line(int width) {
        Random random = new Random();
        line = new char[width];
        for (int i = 0; i < width; i++) {
            this.line[i] = (i % 2 == 0) ? '|' : (random.nextBoolean() ? ' ' : '-');
        }
    }
}
