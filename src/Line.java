import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private int lineLength;
    private ArrayList<Boolean> points = new ArrayList<>();

    Random random = new Random();

    public Line(int numOfParticipants) {
        lineLength = numOfParticipants - 1;
        for (int i = 0; i < lineLength; i++) {
            points.add(bridgeConstructor());
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }

    private boolean bridgeConstructor() {
        if (points.size() == 0) {
            return random.nextBoolean();
        }
        return !points.get(points.size() - 1) & random.nextBoolean();
    }

}
