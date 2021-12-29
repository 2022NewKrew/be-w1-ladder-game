import java.util.ArrayList;
import java.util.Collections;

public class LadderRenderer {
    private final int nameLen;

    public LadderRenderer(int nameLen) {
        this.nameLen = nameLen;
    }

    public void render(LadderInputManager ladderInputManager, LadderMaker ladderMaker) {
        renderPlayers(ladderInputManager.getPlayerList());
        renderLadder(ladderMaker.getLadder(), ladderMaker.getOffset());
    }

    private void renderPlayers(ArrayList<String> playerList) {
        for (String player : playerList) {
            System.out.print(paddingPlayer(player));
        }
        System.out.println();
    }

    private String paddingPlayer(String player) {
        StringBuilder sb = new StringBuilder();
        int length = nameLen - player.length();
        sb.append(" ".repeat(length / 2 + length % 2));
        sb.append(player);
        sb.append(" ".repeat(length / 2));
        return sb.toString();
    }

    private void renderLadder(ArrayList<Line> ladder, int offset) {
        StringBuilder ladderString = new StringBuilder();
        for (Line line : ladder) {
            ladderString.append(renderLine(line.getPoints(), offset));
        }
        System.out.println(ladderString);
    }

    private StringBuilder renderLine(ArrayList<Boolean> points, int offset) {
        StringBuilder lineString = new StringBuilder();

        //offset 만큼 공백을 더함
        lineString.append(String.join("", Collections.nCopies(offset, " ")));

        //nameLen 만큼 공백이나 가로선을 더함
        for (boolean point : points) {
            lineString.append("|");
            lineString.append(renderLineElement(point));
        }
        lineString.append("|\n");

        return lineString;
    }

    private String renderLineElement(boolean point) {
        if (point) return "-".repeat(nameLen);
        return " ".repeat(nameLen);
    }
}
