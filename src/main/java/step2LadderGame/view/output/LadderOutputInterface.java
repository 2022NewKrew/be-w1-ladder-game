package step2LadderGame.view.output;

import step2LadderGame.domain.ladder.Ladder;
import step2LadderGame.domain.ladder.BranchType;

import java.util.List;

public class LadderOutputInterface implements OutputInterface {
    @Override
    public void print(Ladder ladder) {
        final List<List<BranchType>> branchTypeLists = ladder.getBranchTypeLists();

        final StringBuilder sb = new StringBuilder();
        branchTypeLists.forEach(branchTypeList -> appendBranchListStr(sb, branchTypeList));

        System.out.println(sb);
    }

    private void appendBranchListStr(StringBuilder sb, List<BranchType> branchTypeList) {
        branchTypeList.forEach(branchType -> sb.append(branchType.getStr()));
        sb.append('\n');
    }
}
