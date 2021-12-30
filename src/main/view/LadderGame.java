package main.view;

import main.domain.ladder.Ladder;
import main.domain.ladder.LadderFactory;
import main.domain.ladder.RandomLadderFactory;
import main.domain.vo.LadderInput;

import java.util.Scanner;

public class LadderGame {

    public LadderGame() {
    }

    public void start() {
        try (Scanner sc = new Scanner(System.in)) {
            LadderInput ladderInput = getLadderInput(sc);
            LadderPrinter ladderPrinter = createLadderPrinter(new RandomLadderFactory(), ladderInput);
            ladderPrinter.printLadder();
            queryResults(sc, ladderPrinter);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private LadderInput getLadderInput(Scanner sc) {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요.) (최대 5글자)");
        String[] playerNames = sc.nextLine().split("\\s*[,]\\s*");

        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String[] results = sc.nextLine().split("\\s*[,]\\s*");

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = sc.nextInt();
        sc.nextLine(); // 개행문자 제거

        return new LadderInput(playerNames, results, height);
    }

    private LadderPrinter createLadderPrinter(LadderFactory factory, LadderInput gameInput) {
        Ladder ladder = factory.createLadder(gameInput.getPlayerNames(), gameInput.getResults(), gameInput.getHeight());
        return new LadderPrinter(ladder);
    }

    public void queryResults(Scanner sc, LadderPrinter ladderPrinter) {
        while (queryResult(sc, ladderPrinter)); // exit: 춘식이
    }

    private boolean queryResult(Scanner sc, LadderPrinter ladderPrinter) {
        System.out.println("결과를 보고 싶은 사람은?");
        String playerName = sc.nextLine().trim();
        switch (playerName) {
            case "춘식이":
                ladderPrinter.printGameEnd();
                return false;
            case "all":
                ladderPrinter.printAllResults();
                return true;
            default:
                ladderPrinter.printResult(playerName);
                return true;
        }
    }
}
