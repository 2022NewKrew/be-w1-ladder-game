import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Layer> layers;

    public Ladder(int peopleSize, int height) {
        this.layers = new ArrayList<>();

        for (int heightCounter = 0 ; heightCounter < height ; heightCounter++) {
            this.layers.add(new Layer(peopleSize));
        }
    }

    public List<Layer> getLayers () {
        return layers;
    }
}
