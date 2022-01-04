package ladder.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Level {
    private final List<Boolean> points = new ArrayList<>();
    private final int numPlayers;
    private final String rung = "-----|";
    private final String empty = "     |";
    static final Random random = new Random();

    public Level(int numPlayers) {
        this.numPlayers = numPlayers;
        constructLine();
    }

    private void constructLine() {
        while (points.size() < numPlayers-1)
            getNextLineElement();
    }

    private void getNextLineElement() {
        if (!points.isEmpty() && points.get(points.size()-1)) {
            points.add(false);
            return;
        }
        points.add(random.nextBoolean());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('|');
        points.forEach(isRung -> sb.append(isRung ? rung : empty));
        return sb.toString();
    }

}