package service;

import common.value.LadderHeight;
import common.value.PlayerCount;
import service.value.Line;

import java.util.List;

public interface LadderGenerator {
    List<Line> generate(LadderHeight ladderHeight, PlayerCount playerCount);
}
