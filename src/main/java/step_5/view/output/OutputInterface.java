package step_5.view.output;

import step_5.domain.Ladder;
import step_5.dto.LadderInfo;

public interface OutputInterface {
    public abstract void print(LadderInfo ladderInfo, Ladder ladder);
}
