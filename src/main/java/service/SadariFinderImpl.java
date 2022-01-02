package service;

import domain.MovePoint;
import domain.sadari.SadariMap;
import domain.sadari.result.GameResult;
import domain.sadari.result.SadariResult;
import domain.sadari.result.SadariResults;
import domain.user.User;
import domain.user.Users;

import java.util.List;
import java.util.stream.Collectors;


public class SadariFinderImpl implements SadariFinder {

    private final Users users;
    private final SadariMap sadariMap;
    private final SadariResults sadariResults;

    public SadariFinderImpl(Users users, SadariMap sadariMap, SadariResults sadariResults) {
        this.users = users;
        this.sadariMap = sadariMap;
        this.sadariResults = sadariResults;
    }

    @Override
    public GameResult find(String userName) {
        User user = users.getUser(userName);
        MovePoint movePoint = new MovePoint(user.getNumber(), sadariMap);
        for (int i = 0; i < sadariMap.getNumberOfRow(); i++) {
            movePoint.move();
        }

        SadariResult sadariResult = sadariResults.getResult(movePoint.getNumber());
        return new GameResult(user, sadariResult);
    }

    @Override
    public List<GameResult> findAll() {
        return users.getUserNames().stream()
                .map(this::find)
                .collect(Collectors.toUnmodifiableList());

    }

}
