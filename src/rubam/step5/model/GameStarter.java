package rubam.step5.model;

import rubam.step5.domain.Ladder;
import rubam.step5.input.InputLadderInform;
import rubam.step5.view.LadderPrinter;

import java.util.Scanner;

public class GameStarter {

    private static final String END_KEYWORD = "춘식이";
    private static final String END_MESSAGE = "게임을 종료합니다.";
    private static final String GAME_PROCEED_MESSAGE = "결과를 보고 싶은 사람은?";
    private static final String SHOW_EXECUTE_MESSAGE = "실행 결과";
    private static final String WRONG_INPUT_ALERT = "잘못된 입력입니다.";
    private static final String ALL = "all";

    private static final Scanner scanner = new Scanner(System.in);
    private static Ladder ladder;
    private static ResultCalculator resultCalculator;

    public static void gameStart() {
        initSettings();
        runGame();
    }

    private static void runGame() {
        boolean isEnd = false;
        while (!isEnd) {
            System.out.println(GAME_PROCEED_MESSAGE);
            String input = scanner.nextLine();
            isEnd = getResult(input);
        }
        System.out.println(END_MESSAGE);
    }

    private static void initSettings() {
        ladder = InputLadderInform.userInput();
        LadderPrinter.printLadder(ladder);
        resultCalculator = new ResultCalculator(ladder);
    }

    private static Boolean getResult(String userInput) {

        if (userInput.equals(END_KEYWORD))
            return true;
        proceedGame(userInput);
        return false;
    }

    private static void proceedGame(String userInput) {
        boolean isCorrectInput = printResult(userInput);
        if (!isCorrectInput) {
            System.out.println(WRONG_INPUT_ALERT);
        }
    }

    private static Boolean printResult(String userInput) {
        if (isAllPlayer(userInput))
            return true;
        return isSpecificPlayer(userInput);
    }

    private static boolean isAllPlayer(String userInput) {
        if (userInput.equals(ALL)) {
            System.out.println(SHOW_EXECUTE_MESSAGE);
            printAllResults();
            return true;
        }
        return false;
    }

    private static boolean isSpecificPlayer(String userInput) {
        int player = 0;
        boolean isFind = false;

        while (!isFind && player < ladder.getNamesData().size()) {
            isFind = checkPlayerName(userInput, player);
            player++;
        }
        return isFind;
    }

    private static Boolean checkPlayerName(String userInput, int player) {
        if (ladder.getNamesData().get(player).equals(userInput)) {
            System.out.println(SHOW_EXECUTE_MESSAGE);
            System.out.println(ladder
                    .getResultsData()
                    .get(resultCalculator.getGameResult(player)));
            return true;
        }
        return false;
    }

    private static void printAllResults() {
        int player = 0;
        for (int result : resultCalculator.getAllGameResults()) {
            System.out.println(ladder.getNamesData().get(player) + " : " + ladder.getResultsData().get(result));
            player++;
        }
    }
}
