package service;

import domain.sadari.SadariMap;
import domain.sadari.result.GameResult;
import domain.sadari.result.SadariResults;
import domain.user.Users;

import java.util.List;

public class SadariPrinterImpl implements SadariPrinter {

    private final Users users;
    private final SadariMap sadariMap;
    private final SadariResults sadariResults;

    public SadariPrinterImpl(Users users, SadariMap sadariMap, SadariResults sadariResults) {
        this.users = users;
        this.sadariMap = sadariMap;
        this.sadariResults = sadariResults;
    }

    @Override
    public void printSadariGame() {
        System.out.println("사다리 결과");
        users.printUsers();
        sadariMap.printSadari();
        sadariResults.printSadariResults();
    }

    @Override
    public void printPlayResult(GameResult gameResult) {
        System.out.println("실행 결과");
        gameResult.print();
        System.out.println();
    }

    @Override
    public void printAllPlayResult(List<GameResult> gameResults) {
        System.out.println("실행 결과");
        for (GameResult gameResult : gameResults) {
            gameResult.print();
            System.out.println();
        }

    }

}
