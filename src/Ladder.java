import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Ladder {
    private static final Random random = new Random();
    private ArrayList<String> stateAsListOfString;
    private int width, height;

    public Ladder(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void generateSimpleRandom() {
        this.stateAsListOfString = new ArrayList<>();
        for (int lineNo = 0; lineNo < this.height; lineNo++) {
            this.stateAsListOfString.add(Stream.generate(() -> this.random.nextBoolean() ? "-" : " ").limit(this.width - 1).collect(Collectors.joining("|", "|", "|")));
        }
    }

    public String toPrettyString() {
        return String.join(System.lineSeparator(), this.stateAsListOfString);
    }

    @Override
    public String toString() {
        return getClass().getName() + "("
                + "width=" + this.width + ", "
                + "height=" + this.height + ")";
    }
}
