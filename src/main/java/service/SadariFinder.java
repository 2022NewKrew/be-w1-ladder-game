package service;

import domain.sadari.result.GameResult;

import java.util.List;

public interface SadariFinder {

    GameResult find(String userName);

    List<GameResult> findAll();
}
