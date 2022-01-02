package service;

import domain.Ladder;
import domain.PlayerRepository;

public class LadderGameService {

    public static LadderGameResult serviceStart(PlayerRepository playerRepository, Ladder ladder) {
        return new LadderGameResult(playerRepository, ladder);
    }

}
