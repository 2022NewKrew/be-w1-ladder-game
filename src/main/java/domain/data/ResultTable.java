package domain.data;

import common.value.Player;

import java.util.Map;

public class LadderGameResultTable {

    private final Map<Player, Goal> resultTable;

    public LadderGameResultTable(Map<Player, Goal> resultTable) {
        this.resultTable = resultTable;
    }
}
