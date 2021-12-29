package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Branch> branches = new ArrayList<>();

    private Ladder() {
    }

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        branches.forEach(branch -> sb.append(branch).append('\n'));

        return sb.toString();
    }

    public void trace() {
        //TODO 구현 필요
    }
}
