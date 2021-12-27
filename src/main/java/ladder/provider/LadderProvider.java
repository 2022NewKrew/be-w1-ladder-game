package ladder.provider;

public class LadderProvider {

    private final int maxLadderHeight;
    private final int numberOfPlayers;

    public LadderProvider(int maxLadderHeight, int numberOfPlayers) {
        this.maxLadderHeight = maxLadderHeight;
        this.numberOfPlayers = numberOfPlayers;
    }

    public StringBuilder createLadder() {
        return createLadderCols(this.maxLadderHeight, this.numberOfPlayers);
    }

    private StringBuilder createLadderCols(int maxLadderHeight, int numberOfPlayers) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < maxLadderHeight; i++) {
            stringBuilder.append(createLadderRows(numberOfPlayers));
            stringBuilder.append("\n");
        }
        return stringBuilder;
    }

    private StringBuilder createLadderRows(int numberOfPlayers) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numberOfPlayers; i++) {
            stringBuilder.append("|");
            if (isLastLadderLine(numberOfPlayers, i)) {
                continue;
            }
            stringBuilder.append(addLadderAcrossLine());
        }
        return stringBuilder;
    }

    private boolean isLastLadderLine(int maxLadderLine, int currentLadderLine) {
        return (maxLadderLine - 1) == currentLadderLine;
    }

    private String addLadderAcrossLine() {
        if (hasLadderAcrossLine()) {
            return "-";
        }
        return " ";
    }

    private boolean hasLadderAcrossLine() {
        return (int)(Math.random() * 2) == 1;
    }

}
