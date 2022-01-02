package ladder.view;

import ladder.domain.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LadderGamePrinter {
    private static final String EMPTY_STEP_STR = " ";
    private static final String FILLED_STEP_STR = "-";
    private static final String POLE_STR = "|";
    private static final String END_WORD = "춘식이";

    public void printLadderGame(LadderGame game) {
        System.out.println("** 실행 결과 **");

        printPlayers(game.getPlayers());
        printLadder(game.getLadder(), LadderGame.PLAYER_NAME_LENGTH_LIMIT);
        printPrizes(game.getPrizes());
    }

    public void printResult(LadderGame game) {
        Scanner scanner = new Scanner(System.in);
        while (getNext(game, scanner)) {

        }
    }

    private boolean getNext(LadderGame game, Scanner scanner) {
        String input = scanner.nextLine();
        if (input.equals(END_WORD)) {
            return false;
        }
        try {
            Prize prize = game.getPrizeByName(input);
            System.out.println("실행 결과 " + prize);
        } catch (NoSuchElementException e) {
            System.out.println("사람 이름을 다시 입력해주세요");
        }
        return true;
    }

    private void printPlayers(List<Player> players) {
        StringBuilder sb = new StringBuilder();
        for (Player player : players) {
            sb.append(String.format("%-6s", player));
        }
        System.out.println(sb);
    }

    private void printLadder(Ladder ladder, int stepWidth) {
        StringBuilder sb = new StringBuilder();
        List<LadderRow> rows = ladder.getRows();
        rows.forEach(row -> {
            String stepsDisplay = row.getSteps().stream()
                    .map(step -> getStepDisplayString(step, stepWidth))
                    .collect(Collectors.joining(POLE_STR));
            sb.append(POLE_STR)
                    .append(stepsDisplay)
                    .append(POLE_STR)
                    .append(System.lineSeparator());
        });
        System.out.println(sb);
    }

    private String getStepDisplayString(Step step, int width) {
        if (step == Step.FILLED) {
            return FILLED_STEP_STR.repeat(width);
        }
        return EMPTY_STEP_STR.repeat(width);
    }

    private void printPrizes(List<Prize> prizes) {
        StringBuilder sb = new StringBuilder();
        for (Prize prize : prizes) {
            sb.append(String.format("%-6s", prize));
        }
        System.out.println(sb);
    }
}
