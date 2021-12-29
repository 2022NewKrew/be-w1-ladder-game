package ladderGame.domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class LadderIncludeNames extends Ladder {

    private final List<String> nameList = new ArrayList<>();

    public List<String> getNameList() {
        return nameList;
    }

    public void addAllNames(List<String> nameList) {
        this.nameList.addAll(nameList);
    }

    protected LadderIncludeNames(List<Branch> branches) {
        super(branches);
    }
}
