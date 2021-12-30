package be.w1.ladder_game.controller;

import java.util.Arrays;
import java.util.List;

import be.w1.ladder_game.model.Ladder;

public class LadderController {
    private static final String ILLEGAL_PLAYER_COUNT_MESSAGE = "참여할 사람은 최소 2명 이상이어야 합니다.";
    private static final String ILLEGAL_LADDER_HEIGHT_MESSAGE = "사다리 높이는 최소 1 이상이어야 합니다.";
    private static final String ILLEGAL_LONG_PLAYER_NAME_MESSAGE = "참가자 이름은 5글자 이하여야 합니다.";
    private static final String ILLEGAL_SHORT_PLAYER_NAME_MESSAGE = "참가자 이름은 1글자 이상이여야 합니다.";

    private static final int MIN_PLAYER_COUNT = 2;
    private static final int MIN_LADDER_HEIGHT = 1;
    private static final int MIN_PLAYER_NAME_LENGTH = 1;
    private static final int MAX_PLAYER_NAME_LENGTH = 5;

    private static final String PAD = " ";
    private static final String INPUT_SEPARATOR = ",";

    private final Ladder ladder;
    private final List<String> players;

    public LadderController(String playersName, int ladderHeight) {
        List<String> playersList = playersNameToList(playersName);

        validatePlayers(playersList);
        validateLadderHeight(ladderHeight);

        this.players = playersList;
        this.ladder = new Ladder(players.size() - 1, ladderHeight);
    }

    public Ladder getLadder() {return this.ladder;}

    public List<String> getPlayers() {return this.players;}

    private void validatePlayers(List<String> playersList) {
        for (String name : playersList) {
            validatePlayerName(name);
        }

        validatePlayerCount(playersList.size());
    }

    private void validatePlayerName(String name) {
        if (name.length() > MAX_PLAYER_NAME_LENGTH) {
            throw new IllegalArgumentException(ILLEGAL_LONG_PLAYER_NAME_MESSAGE);
        }
        if (name.length() < MIN_PLAYER_NAME_LENGTH) {
            throw new IllegalArgumentException(ILLEGAL_SHORT_PLAYER_NAME_MESSAGE);
        }
    }

    private void validatePlayerCount(int playerCount) {
        if (playerCount < MIN_PLAYER_COUNT) {
            throw new IllegalArgumentException(ILLEGAL_PLAYER_COUNT_MESSAGE);
        }
    }

    private void validateLadderHeight(int ladderHeight) {
        if (ladderHeight < MIN_LADDER_HEIGHT) {
            throw new IllegalArgumentException(ILLEGAL_LADDER_HEIGHT_MESSAGE);
        }
    }

    private List<String> playersNameToList(String playersName) {
        List<String> namesToArray = Arrays.asList(playersName.split(INPUT_SEPARATOR));

        for (int i = 0; i < namesToArray.size(); ++i) {
            namesToArray.set(i, addPaddingToName(namesToArray.get(i)));
        }

        return namesToArray;
    }

    private String addPaddingToName(String name) {
        return PAD.repeat(Math.max(0, (MAX_PLAYER_NAME_LENGTH - name.length()) / 2)) + name;
    }
}

