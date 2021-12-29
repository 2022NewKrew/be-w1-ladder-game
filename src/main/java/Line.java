import java.util.ArrayList;
import java.util.Random;

public class Line {
    private static final Random rand = new Random();
    private final ArrayList<Boolean> points = new ArrayList<>();

    public Line(int numPeople){
        for (int i = 0; i < numPeople; i++) {
            points.add(rand.nextBoolean());
        }
    }

    public ArrayList<Boolean> getPoints() {
        return points;
    }
}
