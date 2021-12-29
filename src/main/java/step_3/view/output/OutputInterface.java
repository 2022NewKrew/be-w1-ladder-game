package step_3.view.output;

import step_3.domain.Ladder;
import step_3.dto.LadderInfo;

public interface OutputInterface {
    public abstract void print(LadderInfo ladderInfo, Ladder ladder);
}
