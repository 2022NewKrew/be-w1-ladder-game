package view.output;

import domain.Ladder;
import dto.LadderInfo;

public interface OutputInterface {
    public abstract void print(LadderInfo ladderInfo, Ladder ladder);
}
