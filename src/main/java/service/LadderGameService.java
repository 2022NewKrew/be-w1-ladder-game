package service;

import domain.Ladder;
import domain.PlayerRepository;

import java.util.List;

public class LadderGameService {

    public static LadderGameResult serviceStart(PlayerRepository playerRepository, Ladder ladder, List<String> inputExecution) {
        return new LadderGameResult(playerRepository, ladder, inputExecution);
    }

}
