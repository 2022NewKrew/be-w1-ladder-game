package ladder.view;

import ladder.domain.ladder.Ladder;

public class LadderRenderer {

    private static final String HORIZONTAL_LINE = "-----";
    private static final String EMPTY_LINE = "     ";
    private static final String EMPTY_SPACE = " ";
    private static final char VERTICAL_LINE = '|';
    private static final char NEW_LINE = '\n';
    private static final int MAX_NAME_LENGTH = 5;

    public static String render(Ladder ladder) {
        StringBuilder sb = new StringBuilder();
        int height = ladder.getHeight();

        renderLadderInfo(sb, ladder.getParticipants());
        for (int currentHeight = 0; currentHeight < height; currentHeight++) {
            renderRow(sb, ladder, currentHeight);
        }
        renderLadderInfo(sb, ladder.getResults());
        return sb.toString();
    }

    private static void renderLadderInfo(StringBuilder sb, String[] strings) {

        for (String data : strings) {
            int emptyPrefixCount = (MAX_NAME_LENGTH - data.length()) / 2;
            int emptyPostfixCount = emptyPrefixCount + (MAX_NAME_LENGTH - data.length()) % 2 + 1;

            sb.append(EMPTY_SPACE.repeat(emptyPrefixCount));
            sb.append(data);
            sb.append(EMPTY_SPACE.repeat(emptyPostfixCount));
        }
        sb.append(NEW_LINE);
    }

    private static void renderRow(StringBuilder sb, Ladder ladder, int currentHeight) {
        int numOfParticipants = ladder.getParticipants().length;

        sb.append(EMPTY_SPACE.repeat(MAX_NAME_LENGTH / 2));
        for (int currentWidth = 0; currentWidth < numOfParticipants - 1; currentWidth++) {
            sb.append(VERTICAL_LINE);
            sb.append(getStringFromCurrentPosition(ladder, currentWidth, currentHeight));
        }
        sb.append(VERTICAL_LINE);
        sb.append(NEW_LINE);
    }

    private static String getStringFromCurrentPosition(Ladder ladder, int currentWidth, int currentHeight) {
        if (ladder.isConnected(currentWidth, currentHeight)) {
            return HORIZONTAL_LINE;
        }
        return EMPTY_LINE;
    }

}
