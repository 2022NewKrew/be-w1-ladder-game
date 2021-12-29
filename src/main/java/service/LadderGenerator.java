package service;

import configuration.LadderHeight;
import configuration.PeopleCount;

public interface LadderGenerator {
    boolean[][] generate(LadderHeight ladderHeight, PeopleCount peopleCount);
}
