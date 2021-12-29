import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ladder {

    private final int PLAYER_NUMBER;
    private final int LADDER_HEIGHT;
    private final List<String> PLAYER_LIST = new ArrayList<>();
    private final List<Line> LINE_LIST = new ArrayList<>();

    public Ladder(String[] playerNames, int ladderHeight) {
        PLAYER_NUMBER = playerNames.length;;
        LADDER_HEIGHT = ladderHeight;
        PLAYER_LIST.addAll(Arrays.asList(playerNames));
        for (int i = 0; i < LADDER_HEIGHT; i++) {
            LINE_LIST.add(new Line(PLAYER_NUMBER));
        }
    }

    public List<String> getPLAYER_LIST() {
        return PLAYER_LIST;
    }

    public List<Line> getLINE_LIST() {
        return LINE_LIST;
    }
}
