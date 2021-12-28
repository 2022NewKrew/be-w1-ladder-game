import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Layer {
    private final List<Boolean> horizontalLines;

    public Layer(int peopleSize) {
        Random random = new Random();

        this.horizontalLines = new ArrayList<>();

        for (int peopleCounter = 0; peopleCounter < peopleSize - 1 ; peopleCounter++) {
            this.horizontalLines.add(random.nextBoolean());
        }
    }

    public List<Boolean> getHorizontalLines() {
        return horizontalLines;
    }
}
