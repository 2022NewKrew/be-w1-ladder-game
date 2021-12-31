package domain.data;

import java.util.List;

public class LadderResults {

    private final List<Goal> resultList;

    public LadderResults(List<Goal> resultList) {
        this.resultList = resultList;
    }

    public Goal getResult(int index) {
        return resultList.get(index);
    }

    public int getCount() { return resultList.size(); }
}
