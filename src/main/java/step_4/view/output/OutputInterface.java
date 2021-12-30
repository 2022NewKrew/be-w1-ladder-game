package step_4.view.output;

import step_4.domain.Ladder;
import step_4.dto.LadderInfo;

public interface OutputInterface {
    public abstract void print(LadderInfo ladderInfo, Ladder ladder);
}
