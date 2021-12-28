package ladder;

public class LadderRenderer {

    private static final String VERTICAL_LINE = "|";
    private static final String HORIZONTAL_LINE = "-";
    private static final String EMPTY_LINE = " ";

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
            sb.append((ladder.isConnected(currentWidth, currentHeight)) ? HORIZONTAL_LINE : EMPTY_LINE);
        }
        sb.append(VERTICAL_LINE + "\n");
    }

}
