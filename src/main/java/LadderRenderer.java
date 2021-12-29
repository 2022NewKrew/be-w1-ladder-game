public class LadderRenderer {
    private final StringBuilder builder = new StringBuilder();
    private int maxLength = 5;

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public void render(Ladder ladder) {
        renderParticipants(ladder.getParticipants());
        renderLadderData(ladder.getLadderData());
        System.out.print(builder);
    }

    private void renderParticipants(String[] participants) {
        for (String participant : participants) {
            builder.append(alignCenter(participant));
            builder.append(" ");
        }
        builder.append("\n");
    }

    private String alignCenter(String s) {
        int leftPadding = (maxLength - s.length()) / 2;
        int rightPadding = maxLength - s.length() - leftPadding;
        return " ".repeat(leftPadding) + s + " ".repeat(rightPadding);
    }

    private void renderLadderData(LadderData ladderData) {
        for (LadderRow ladderRow : ladderData) {
            builder.append(" ".repeat(maxLength / 2));
            renderRow(ladderRow);
            builder.append("\n");
        }
    }

    private void renderRow(LadderRow ladderRow) {
        for (Boolean ladderExist : ladderRow) {
            builder.append("|");
            builder.append(getLadderString(ladderExist));
        }
        builder.append("|");
    }

    private String getLadderString(Boolean ladderExist) {
        if (ladderExist) {
            return "-".repeat(maxLength);
        }
        return " ".repeat(maxLength);
    }
}
