package service;

import domain.ladder.Ladder;
import domain.ladder.line.Line;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LadderService {

    private Ladder ladder;

    public LadderService(Ladder ladder) {
        this.ladder = ladder;
    }

    public List<List<Boolean>> getLadder() {
        return ladder.getLadder().stream()
                .map(Line::getLines)
                .collect(Collectors.toList());
    }

    public List<List<Boolean>> createLadderForGame(int participantNumber) {
        List<List<Boolean>> originLadder = getLadder();
        List<List<Boolean>> gameLadder = new ArrayList<>();
        for (int row = 0; row < ladder.getLadder().size() + 2; row++) {
            List<Boolean> list = new ArrayList<>();
            createLadderColumnForGame(participantNumber, originLadder, row, list);
            gameLadder.add(list);
        }

        return gameLadder;
    }

    private void createLadderColumnForGame(int participantNumber, List<List<Boolean>> originLadder, int row, List<Boolean> list) {
        for (int column = 0; column < ladder.getLadder().get(0).getLineCount() + participantNumber; column++) {
            list.add(true);
            initColumn(row, column, list);
            initLadderColumn(originLadder, row, column, list);
        }
    }

    private void initLadderColumn(List<List<Boolean>> originLadder, int row, int column, List<Boolean> list) {
        if (row > 0 && row < ladder.getLadder().size() + 1 && column % 2 == 1) {
            list.set(column, originLadder.get(row - 1).get(column / 2));
        }
    }

    private void initColumn(int row, int column, List<Boolean> list) {
        if ((row == 0 || row == ladder.getLadder().size() + 1) && column % 2 == 1) {
            list.set(column, false);
        }
    }
}
