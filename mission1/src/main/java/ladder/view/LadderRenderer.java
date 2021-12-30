package ladder.view;

import ladder.constant.Const;
import ladder.domain.Line;
import ladder.entity.LadderInfo;
import ladder.entity.LadderInput;

import java.util.ArrayList;
import java.util.Collections;

public class LadderRenderer {
    private final LadderInput ladderInput;
    private final LadderInfo ladderInfo;
    private final int offset;

    public LadderRenderer(LadderInput ladderInput, LadderInfo ladderInfo) {
        this.ladderInput = ladderInput;
        this.ladderInfo = ladderInfo;
        offset = Const.MAX_NAME_LEN / 2;
    }

    public void render() {
        renderPlayers(ladderInput.getPlayerList());
        renderLadder(ladderInfo.getLadder());
    }

    private void renderPlayers(ArrayList<String> playerList) {
        for (String player : playerList) {
            System.out.print(paddingPlayer(player));
        }
        System.out.println();
    }

    private String paddingPlayer(String player) {
        StringBuilder sb = new StringBuilder();
        int length = Const.MAX_NAME_LEN - player.length();
        sb.append(" ".repeat(length / 2 + length % 2));
        sb.append(player);
        sb.append(" ".repeat(length / 2));
        return sb.toString();
    }

    private void renderLadder(ArrayList<Line> ladder) {
        StringBuilder ladderString = new StringBuilder();
        for (Line line : ladder) {
            ladderString.append(renderLine(line.getPoints(), offset));
        }
        System.out.println(ladderString);
    }

    private StringBuilder renderLine(ArrayList<Boolean> points, int offset) {
        StringBuilder lineString = new StringBuilder();

        lineString.append(" ".repeat(offset));

        for (boolean point : points) {
            lineString.append("|");
            lineString.append(renderLineElement(point));
        }
        lineString.append("|\n");

        return lineString;
    }

    private String renderLineElement(boolean point) {
        if (point) return "-".repeat(Const.MAX_NAME_LEN);
        return " ".repeat(Const.MAX_NAME_LEN);
    }
}
