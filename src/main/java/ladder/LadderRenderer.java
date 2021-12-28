package ladder;

public class LadderRenderer {

    private static final char VERTICAL_LINE = '|';
    private static final char HORIZONTAL_LINE = '-';
    private static final char EMPTY_LINE = ' ';
    private static final char NEW_LINE = '\n';

    public static void render(Ladder ladder) {
        StringBuilder sb = new StringBuilder();
        int height = ladder.getHeight();

        for (int currentHeight = 0; currentHeight < height; currentHeight++) {
            renderRow(sb, ladder, currentHeight);
        }
        System.out.print(sb);
    }

    private static void renderRow(StringBuilder sb, Ladder ladder, int currentHeight) {
        int participants = ladder.getParticipants();

        for (int currentWidth = 0; currentWidth < participants - 1; currentWidth++) {
            sb.append(VERTICAL_LINE);
            sb.append(getCharFromCurrentPosition(ladder, currentWidth, currentHeight));
        }
        sb.append(VERTICAL_LINE);
        sb.append(NEW_LINE);
    }

    private static char getCharFromCurrentPosition(Ladder ladder, int currentWidth, int currentHeight) {
        if (ladder.isConnected(currentWidth, currentHeight)) {
            return HORIZONTAL_LINE;
        }
        return EMPTY_LINE;
    }

}
