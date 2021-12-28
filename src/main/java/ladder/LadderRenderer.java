package ladder;

public class LadderRenderer {

    private static final String VERTICAL_LINE = "|";
    private static final String HORIZONTAL_LINE = "-";
    private static final String EMPTY_LINE = " ";

    public static void render(Ladder ladder) {
        StringBuilder sb = new StringBuilder();
        int participants = ladder.getParticipants();
        int height = ladder.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < participants - 1; x++) {
                sb.append(VERTICAL_LINE);
                sb.append((ladder.isConnected(x, y)) ? HORIZONTAL_LINE : EMPTY_LINE);
            }
            sb.append(VERTICAL_LINE + "\n");
        }
        System.out.print(sb);
    }

}
