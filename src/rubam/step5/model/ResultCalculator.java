package rubam.step5.model;

import rubam.step5.domain.Ladder;
import rubam.step5.domain.Line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResultCalculator {

    private final Ladder ladder;
    private final int people;
    private final List<Integer> gameResults = new ArrayList<>();

    public ResultCalculator(Ladder ladder) {
        this.ladder = ladder;
        this.people = ladder.getNamesData().size();
        executeGame();
    }

    public int getGameResult(int player) {
        return gameResults.get(player);
    }

    public List<Integer> getAllGameResults() {
        return Collections.unmodifiableList(gameResults);
    }

    private void executeGame() {

        for (int i = 0; i < people; i++) {
            gameResults.add(calculateLines(i));
        }
    }

    private int calculateLines(int currentLocation) {
        for (Line line : ladder.getLinesData()) {
            currentLocation = calculateStep(currentLocation, line);
        }
        return currentLocation;
    }

    private int calculateStep(int currentLocation, Line line) {

        if (currentLocation != line.getStepsData().size() && line.getStepsData().get(currentLocation))
            return currentLocation + 1;
        else if (currentLocation > 0 && line.getStepsData().get(currentLocation - 1))
            return currentLocation - 1;
        return currentLocation;
    }
}
