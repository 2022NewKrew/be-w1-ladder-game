package domain.data;

import common.value.Player;

import java.util.Map;

public class ResultTable {

    private final Map<Player, Goal> resultTable;

    public ResultTable(Map<Player, Goal> resultTable) {
        this.resultTable = resultTable;
    }

    public Goal getGoal(Player player) {
        return resultTable.get(player);
    }
}
