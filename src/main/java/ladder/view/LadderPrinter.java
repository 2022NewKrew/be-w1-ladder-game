package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.LadderGame;
import ladder.domain.LadderRow;
import ladder.domain.Step;

import java.util.List;

public class LadderPrinter {
    private final String EMPTY_STR = " ";
    private final String FILLED_STR = "-";
    private final String POLE_STR = "|";

    public void printLadderGame(LadderGame game) {
        System.out.println("** 실행 결과 **");

        printPlayers(game.getPlayers());
        printLadder(game.getLadder(), game.getPlayerNameLengthLimit());
    }

    private void printPlayers(List<String> players) {
        StringBuilder sb = new StringBuilder();
        for (String player: players) {
            sb.append(String.format("%-6s", player));
        }
        System.out.println(sb);
    }

    private void printLadder(Ladder ladder, int stepWidth) {
        StringBuilder sb = new StringBuilder();
        List<LadderRow> rows = ladder.getRows();
        for (LadderRow row : rows) {
            List<Step> steps = row.getSteps();
            for (Step step : steps) {
                sb.append(POLE_STR + getStepDisplayString(step, stepWidth));
            }
            sb.append(POLE_STR + System.lineSeparator());
        }
        System.out.println(sb);
    }

    private String getStepDisplayString(Step step, int width) {
        if (step == Step.FILLED) {
            return FILLED_STR.repeat(width);
        }
        return EMPTY_STR.repeat(width);
    }
}
