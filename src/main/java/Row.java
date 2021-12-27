import java.util.Random;

public class Row {
    private boolean[] bridges;
    private final Random RANDOM = new Random();

    public Row(int people) {
        bridges = new boolean[people];
        makeBridges();
    }

    private void makeBridges() {
        for (int i = 0; i < bridges.length - 1; i++) {
            bridges[i] = RANDOM.nextBoolean();
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (boolean bridge : bridges) {
            sb.append('|');
            sb.append(bridge ? '-' : ' ');
        }
        sb.append('\n');
        return sb.toString();
    }
}
