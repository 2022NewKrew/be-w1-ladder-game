import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private final List<List<Boolean>> layers;

    public Ladder(int peopleSize, int height) {
        Random random = new Random();
        layers = new ArrayList<>();

        for (int heightCounter = 0 ; heightCounter < height ; heightCounter++) {
            List<Boolean> layer = new ArrayList<>();
            for (int peopleCounter = 0 ; peopleCounter < peopleSize - 1 ; peopleCounter++) {
                layer.add(random.nextBoolean());
            }
            layers.add(layer);
        }
    }

    public void printLadder() {
        for (List<Boolean> layer : layers) {
            System.out.print("|");
            for (Boolean horizontalLineExists : layer) {
                if (horizontalLineExists) {
                    System.out.print("-|");
                }
                else {
                    System.out.print(" |");
                }
            }
            System.out.println();
        }
    }
}
