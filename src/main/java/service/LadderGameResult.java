package service;

import domain.Ladder;
import domain.PlayerRepository;

import java.util.HashMap;
import java.util.Map;

public class LadderGameResult {
    private final Map<String, Integer> result;

    public LadderGameResult(PlayerRepository playerRepository, Ladder ladder) {
        this.result = new HashMap<>();
    }
}
