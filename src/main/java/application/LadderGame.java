package application;

import domain.Ladder;
import domain.User;
import view.GameGuidePrinter;
import view.LadderPrinter;

import java.util.List;

public class LadderGame {
    public static final int MAXIMUM_NAME_LENGTH = 5;

    public static void main(String[] args) {
        ladderGamePlay();
    }

    public static void ladderGamePlay() {
        GameGuidePrinter.userListInputGuide();
        List<User> nameList = GameInputScanner.inputNameList();

        GameGuidePrinter.resultListInputGuide();
        List<String> resultList = GameInputScanner.inputResultList(nameList.size());

        GameGuidePrinter.heightOfLadderInputGuide();
        int heightLadder = GameInputScanner.inputNumber();

        Ladder ladder = makeLadder(nameList, resultList, heightLadder);
        checkLadderGameResult(nameList, resultList, ladder);
    }

    private static Ladder makeLadder(List<User> nameList, List<String> resultList, int heightLadder) {
        Ladder ladder = new Ladder(LineGeneratorFactory.getLadderLines(nameList.size() - 1, heightLadder));
        LadderPrinter.drawLadder(nameList, ladder, resultList);
        return ladder;
    }


    private static void checkLadderGameResult(List<User> nameList, List<String> resultList, Ladder ladder) {
        while (true) {
            GameGuidePrinter.resultOfUserInputGuide();
            String nameCheckResult = GameInputScanner.inputNameCheckResult(nameList);

            if (quitLadderGame(nameCheckResult)) return;
            if (printAllResult(nameList, resultList, ladder, nameCheckResult)) continue;

            printOneResult(nameList, resultList, ladder, nameCheckResult);
        }
    }

    private static void printOneResult(List<User> nameList, List<String> resultList, Ladder ladder, String nameCheckResult) {
        User user = nameList.stream()
                .filter(e -> nameCheckResult.equals(e.getName()))
                .distinct()
                .findAny()
                .get();
        System.out.println(resultList.get(user.getResultCol(ladder)));
    }

    private static boolean printAllResult(List<User> nameList, List<String> resultList, Ladder ladder, String nameCheckResult) {
        if (nameCheckResult.equals("all")) {
            nameList.forEach(user -> System.out.println(user.getName() + ": " + resultList.get(user.getResultCol(ladder))));
            return true;
        }
        return false;
    }

    private static boolean quitLadderGame(String nameCheckResult) {
        if (nameCheckResult.equals("춘식이")) {
            GameGuidePrinter.finishOfGame();
            return true;
        }
        return false;
    }

}