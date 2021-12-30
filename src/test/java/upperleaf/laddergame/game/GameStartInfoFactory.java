package upperleaf.laddergame.game;

import java.util.List;

public class GameStartInfoFactory {

    public GameStartInfo create() {
        List<String> players = List.of("p1", "p2", "p3", "p4");
        List<String> results = List.of("r1", "r2", "r3", "r4");
        int maxLadderHeight = 5;
        return new GameStartInfo(players, results, maxLadderHeight);
    }
}
