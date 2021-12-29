package ladder.domain;

public class LadderComponent {
    public static final int MAX_NAME_LENGTH=5;
    public static final String VERTICAL_LADDER="|";
    public static final String HORIZON_LADDER="-".repeat(MAX_NAME_LENGTH);
    public static final String BLANK=" ".repeat(MAX_NAME_LENGTH);
    public static final String LADDER_INTENT=" ".repeat(MAX_NAME_LENGTH/2+1);
}
