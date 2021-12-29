import java.util.ArrayList;
import java.util.Random;

public class Line {
    private final ArrayList<Boolean> connections = new ArrayList<>();

    public Line (int numOfPeople, Random random) {
        for(int person = 0; person < numOfPeople - 1; person++) {
            connections.add(random.nextBoolean());
        }
    }

    public Boolean get(int idx){
        return connections.get(idx);
    }
}
