import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Ladder {
    private static final Random random = new Random();
    private List<String> stateAsListOfString;
    private final int width, height;
    private List<Player> players;

    private static final int STEP_WIDTH = 5;
    private static final String STEP = "-".repeat(STEP_WIDTH);
    private static final String NO_STEP = " ".repeat(STEP_WIDTH);
    private static final String BEAM = "|";
    private static final String FIRST_BEAM = " ".repeat(STEP_WIDTH - 1) + BEAM;

    public Ladder(List<Player> players, int height) {
        this.players = players;
        this.width = players.size();
        this.height = height;
        this.makeRandomLadder();
    }

    private String makeRandomLine() {
        StringBuilder line = new StringBuilder(FIRST_BEAM);
        boolean isLastBeamAvailable = true;
        for (int beamNo = 0; beamNo < width - 1; beamNo++) {
            boolean isCurrentBeamUsed = isLastBeamAvailable && random.nextBoolean();
            line.append(isCurrentBeamUsed ? STEP : NO_STEP);
            line.append(BEAM);
            isLastBeamAvailable = !isCurrentBeamUsed;
        }
        return line.toString();
    }

    private void makeRandomLadder() {
        stateAsListOfString = new ArrayList<>();
        for (int lineNo = 0; lineNo < height; lineNo++) {
            stateAsListOfString.add(makeRandomLine());
        }
    }

    private static String getPaddedPlayerName(Player player){
        if (player.name.length() > STEP_WIDTH) {
            // Should not happen
            // Throws Exception?
        }
        int totalSpaceCount = STEP_WIDTH - player.name.length();
        int leftSpaceCount = totalSpaceCount / 2;
        int rightSpaceCount = totalSpaceCount - leftSpaceCount;
        return " ".repeat(leftSpaceCount) + player.name + " ".repeat(rightSpaceCount);
    }

    public String toPrettyString() {
        String playersName = " ".repeat(STEP_WIDTH/2) + String.join(" ", players.stream().map(player -> getPaddedPlayerName(player)).toList());
        String ladderShape = String.join(System.lineSeparator(), stateAsListOfString);
        return playersName + System.lineSeparator() + ladderShape;
    }

    @Override
    public String toString() {
        return getClass().getName()
                + "(width=" + width + ", "
                + "height=" + height + ", "
                + "players=" + players + ")";
    }
}
