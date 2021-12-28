import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {

    private final List<List<Boolean>> ladders = new ArrayList<>();
    private final Random random = new Random();
    private final LadderInfo info;

    Ladder(LadderInfo info) {
        this.info = info;
        makeLadders();
    }


    private void makeLadders() {
        for (int i = 0; i < info.height; i++) {
            setLaddersData();
        }
    }

    private void setLaddersData() {
        List<Boolean> line = new ArrayList<>();
        for (int j = 0; j < info.width - 1; j++) {
            line.add(random.nextBoolean());
        }
        ladders.add(line);
    }

    List<List<Boolean>> getLadderData() {
        return ladders;
    }
}
