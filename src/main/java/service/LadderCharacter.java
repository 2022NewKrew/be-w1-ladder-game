package service;

public class LadderCharacter {
    public static final String CONNECTED = calculateConnectionLine();
    public static final String COLUMN = "|";
    public static final String NOT_CONNECTED = calculateNotConnectionLine();
    public static final String FIRST_COLUMN = "  |";
    public static final String SPACE = " ";
    public static final String SUFFIX = " ";
    public static final String PREFIX = " ";

    private static String calculateConnectionLine() {
        StringBuilder connectedLine = new StringBuilder();
        for (int i = 0; i < LadderSizeConfig.LADDER_WIDTH; i++) {
            connectedLine.append("-");
        }
        return connectedLine.toString();
    }

    private static String calculateNotConnectionLine() {
        StringBuilder connectedLine = new StringBuilder();
        for (int i = 0; i < LadderSizeConfig.LADDER_WIDTH; i++) {
            connectedLine.append(" ");
        }
        return connectedLine.toString();
    }
}
