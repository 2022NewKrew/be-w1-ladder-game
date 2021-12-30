package service;

public class LadderCharacter {
    public static final String CONNECTED = calculateConnectionLine();
    public static final String COLUMN = "|";
    public static final String NOT_CONNECTED = calculateNotConnectionLine();
    public static final String FIRST_COLUMN = "  |";
    public static final String SPACE = " ";
    public static final String SUFFIX = " ";
    public static final String PREFIX = " ";
    public static final String NEWLINE = "\n";

    private static String calculateConnectionLine() {
        return "-".repeat(LadderSizeConfig.LADDER_CONNECTION_LENGTH);
    }

    private static String calculateNotConnectionLine() {
        return " ".repeat(LadderSizeConfig.LADDER_CONNECTION_LENGTH);
    }
}
