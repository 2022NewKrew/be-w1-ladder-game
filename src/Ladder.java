import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Ladder {
    private static final Random random = new Random();
    private ArrayList<String> stringRepr;
    private int width, height;

    public Ladder(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void generateSimpleRandom() {
        this.stringRepr = new ArrayList<>();
        for (int lineNo = 0; lineNo < this.height; lineNo++) {
            this.stringRepr.add(Stream.generate(() -> this.random.nextBoolean() ? "-" : " ").limit(this.width - 1).collect(Collectors.joining("|", "|", "|")));
        }
    }

    public String toString() {
        return String.join("\n", this.stringRepr);
    }
}
