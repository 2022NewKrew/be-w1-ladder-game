import java.util.ArrayList;
import java.util.Random;

public class Line {
    private static final Random rand = new Random();
    private final ArrayList<Boolean> points = new ArrayList<>();

    public Line(int numPeople){
        for (int i = 0; i < numPeople; i++) {
            addPoints(i);
        }
    }

    public ArrayList<Boolean> getPoints() {
        return points;
    }
    private void addPoints(int i){
        if(isNextLadder(i)){
            points.add(false);
            return;
        }
        points.add(rand.nextBoolean());
    }

    private boolean isNextLadder(int i){
        if(i==0){
            return false;
        }
        return points.get(i-1);
    }
}
