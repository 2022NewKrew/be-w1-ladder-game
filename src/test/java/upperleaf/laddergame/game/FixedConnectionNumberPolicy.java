package upperleaf.laddergame.game;

import upperleaf.laddergame.domain.Ladder;
import upperleaf.laddergame.domain.connector.ConnectionNumberPolicy;

public class FixedConnectionNumberPolicy implements ConnectionNumberPolicy {

    private final int fixedValue;

    public FixedConnectionNumberPolicy(int value) {
        this.fixedValue = value;
    }

    @Override
    public int getConnectionNumber(Ladder ladder) {
        return fixedValue;
    }
}
