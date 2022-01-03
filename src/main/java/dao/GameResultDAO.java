package dao;

import domain.gameResult.GameResult;

import java.util.List;

public class GameResultDAO {
    private static GameResultDAO INSTANCE;

    public GameResult gameResult;

    private GameResultDAO() {
    }

    public static synchronized GameResultDAO getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GameResultDAO();
        }
        return INSTANCE;
    }

    public void saveGameResult(List<Integer> indexes, List<String> users, List<String> results) {
        gameResult = new GameResult(indexes, users, results);
    }

    public GameResult getGameResult() {
        return gameResult;
    }
}
