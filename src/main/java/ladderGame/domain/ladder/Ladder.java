package ladderGame.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    protected final List<Branch> branches = new ArrayList<>();

    protected Ladder(List<Branch> branches) {
        addAllBranch(branches);
    }

    public int getHeight() {
        return branches.size();
    }

    public int getWidth() {
        if (branches.isEmpty()) {
            return 0;
        }
        return branches.get(0).getWidth();
    }

    private void addAllBranch(List<Branch> branch) {
        branches.addAll(branch);
    }

    public List<List<BranchType>> getBranchTypeLists() {
        return branches.stream()
                .map(Branch::getConnectedInfoList)
                .collect(Collectors.toList());
    }

    public void trace() {
        //TODO 구현 필요
    }
}
