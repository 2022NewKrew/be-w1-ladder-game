package dao;

import domain.ladder.Ladder;

public class LadderDAO {

    private static LadderDAO INSTANCE;

    private Ladder ladder;

    private LadderDAO() {
    }

    public static synchronized LadderDAO getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LadderDAO();
        }
        return INSTANCE;
    }

    public void saveLadder(int frameLength, int height) {
        ladder = new Ladder(frameLength, height);
    }

    public Ladder getLadder() {
        return ladder;
    }
}
