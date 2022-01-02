package service;

import domain.sadari.result.GameResult;

import java.util.List;

public interface SadariPrinter {

    void printSadariGame();

    void printPlayResult(GameResult gameResult);

    void printAllPlayResult(List<GameResult> gameResultList);
}
