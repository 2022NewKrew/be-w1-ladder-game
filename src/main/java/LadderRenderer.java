public class LadderRenderer {

    public static void render(Ladder ladder) {
        StringBuilder builder = new StringBuilder();
        for (LadderRow ladderRow : ladder) {
            renderRow(ladderRow, builder);
            builder.append("\n");
        }
        System.out.print(builder);
    }

    private static void renderRow(LadderRow ladderRow, StringBuilder builder) {
        for (Boolean ladderExist : ladderRow) {
            builder.append("|");
            builder.append(ladderBooleanToString(ladderExist));
        }
        builder.append("|");
    }

    private static String ladderBooleanToString(Boolean ladderExist) {
        if (ladderExist) {
            return "-";
        }
        return " ";
    }
}
