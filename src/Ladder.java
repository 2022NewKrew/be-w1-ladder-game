import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Ladder {
    private static final Random random = new Random();
    private List<String> stateAsListOfString;
    private final int width, height;
    private final String STEP = "-";
    private final String NO_STEP = " ";
    private final String BEAM = "|";

    public Ladder(int width, int height) {
        this.width = width;
        this.height = height;
        this.generateSimpleRandom();
    }

    public void generateSimpleRandom() {
        stateAsListOfString = new ArrayList<>();
        for (int lineNo = 0; lineNo < height; lineNo++) {
            stateAsListOfString.add(Stream.generate(() -> random.nextBoolean() ? STEP : NO_STEP).limit(width - 1).collect(Collectors.joining(BEAM, BEAM, BEAM)));
        }
    }

    public String toPrettyString() {
        return String.join(System.lineSeparator(), stateAsListOfString);
    }

    @Override
    public String toString() {
        return getClass().getName() + "("
                + "width=" + width + ", "
                + "height=" + height + ")";
    }
}
