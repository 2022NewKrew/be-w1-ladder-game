package laddergame.domain;

import laddergame.view.View;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderGame {

    private final View view;
    private Ladder ladder;
    private List<User> users;
    private Map<String, String> gameResult = new HashMap<>();

    private final static String END_GAME_STRING = "춘식이";

    public LadderGame(View view) {
        this.view = view;
    }

    public void run() {
        List<String> userNameList = view.readUserName();
        makeUsers(userNameList);

        List<String> gameResultsTexts = view.readGameResultText();

        Integer ladderCount = view.readLadderCount();
        makeLadder(getUserCount(), ladderCount);

        view.printLadderBoard(ladder, users, gameResultsTexts);

        saveGameResult(gameResultsTexts);
        getGameResultWhileExit();
    }

    private void makeLadder(int userCount, int ladderCount) {
        this.ladder = new Ladder(userCount, ladderCount);
    }

    private void makeUsers(List<String> splitUser) {

        this.users = splitUser.stream()
                .map(User::new)
                .collect(Collectors.toList());
    }

    private Integer getUserCount() {
        return users.size();
    }

    private void saveGameResult(List<String> gameResultTexts) {
        int startVertical = 0;
        for (String gameResult : gameResultTexts) {
            saveGameResultOfEachUser(startVertical, gameResult);
            startVertical++;
        }
    }

    private void saveGameResultOfEachUser(Integer startVertical, String gameResultText) {
        LocationOfUser locationOfUser = new LocationOfUser(startVertical, ladder.getLadder().size() - 1);

        for (int i = ladder.getLadder().size() - 1; i >= 0; i--) {
            LadderComponent currentLadderComponent = ladder.getLadderComponent(locationOfUser.getCurrentRow(), locationOfUser.getCurrentVertical());
            moveUser(currentLadderComponent, locationOfUser);
        }

        gameResult.put(users.get(locationOfUser.getCurrentVertical()).getName(), gameResultText);
    }

    private void moveUser(LadderComponent currentLadderComponent, LocationOfUser locationOfUser) {
        if (currentLadderComponent.hasLeftHorizon()) {
            locationOfUser.moveLeft();
        }

        if (currentLadderComponent.hasRightHorizon()) {
            locationOfUser.moveRight();

        }

        locationOfUser.moveUpper();
    }

    private void getGameResultWhileExit() {
        String userName;
        while (isEndOfGame((userName = view.readUserNameForGameResult()))) {
            getGameResultWithName(userName);
        }
    }

    private void getGameResultWithName(String userName) {
        if (userName.equals("all")) {
            view.printGameResultOfAllUser(gameResult);
            return;
        }

        view.printGameResultOfEachUser(gameResult, userName);
    }

    private Boolean isEndOfGame(String userName) {
        if (userName.equals(END_GAME_STRING)) {
            view.printEndGameComment();
            return false;
        }

        return true;
    }

    private class LocationOfUser {
        private int currentVertical;
        private int currentRow;

        public LocationOfUser(int startVertical, int currentRow) {
            this.currentVertical = startVertical;
            this.currentRow = currentRow;
        }

        public void moveRight() {
            this.currentVertical++;
        }

        public void moveLeft() {
            this.currentVertical--;
        }

        public void moveUpper() {
            this.currentRow--;
        }

        public Integer getCurrentRow() {
            return this.currentRow;
        }

        public Integer getCurrentVertical() {
            return this.currentVertical;
        }

    }
}
