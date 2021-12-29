package ladderGame.view.output;

import ladderGame.domain.ladder.Ladder;
import ladderGame.domain.ladder.BranchType;

import java.util.List;

public class Ladder5sizeOutputInterface implements OutputInterface {
    @Override
    public void print(Ladder ladder) {
        final List<List<BranchType>> branchTypeLists = ladder.getBranchTypeLists();

        final StringBuilder sb = new StringBuilder();
        branchTypeLists.forEach(branchTypeList -> appendBranchListStr(sb, branchTypeList));

        System.out.println(sb);
    }

    private void appendBranchListStr(StringBuilder sb, List<BranchType> branchTypeList) {
        sb.append("  ");
        branchTypeList.forEach(branchType -> append5sizeBranchType(sb, branchType));
        sb.append('\n');
    }

    private void append5sizeBranchType(StringBuilder sb, BranchType branchType) {
        if (branchType.equals(BranchType.USER_LINE)) {
            sb.append(branchType.getStr());
            return;
        }
        sb.append(branchType.getStr().repeat(5));
    }
}
