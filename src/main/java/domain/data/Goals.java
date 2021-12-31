package domain.data;

import java.util.List;

public class Goals {

    private final List<Goal> goalList;

    public Goals(List<Goal> goalList) {
        this.goalList = goalList;
    }

    public Goal getGoal(int index) {
        return goalList.get(index);
    }

    public int getCount() { return goalList.size(); }
}
