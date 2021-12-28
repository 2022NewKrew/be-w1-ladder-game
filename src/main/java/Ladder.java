import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private final List<Layer> layers;

    public Ladder(int peopleSize, int height) {
        this.layers = new ArrayList<>();

        for (int heightCounter = 0 ; heightCounter < height ; heightCounter++) {
            this.layers.add(new Layer(peopleSize));
        }
    }

    public void printLadder() {
        for (Layer layer : this.layers) {
            layer.printLayer();
        }
    }
}
