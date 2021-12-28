import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Ladder {
    // 4. Fields to save ladder state
    private static final Random random = new Random();
    private int width, height;
    private ArrayList<String> stringRepr;


    // 1. Constructor to initialize ladder parameters(width(number of players), height)
    public Ladder(int width, int height) {
        this.width = width;
        this.height = height;
    }


    // 2. Method to (re)generate ladder
    public void generateSimpleRandom() {
        this.stringRepr = new ArrayList<>();
        for (int lineNo = 0; lineNo < this.height; lineNo++) {
            this.stringRepr.add(Stream.generate(() -> this.random.nextBoolean() ? "-" : " ").limit(this.width - 1).collect(Collectors.joining("|", "|", "|")));
        }
    }


    // 3. toString() method
    public String toString() {
        return String.join("\n", this.stringRepr);
    }
}
