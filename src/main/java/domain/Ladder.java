package domain;

import DTO.InputDTO;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Ladder {
    private final List<String> people;
    private final List<String> peopleSwapped;
    private final List<String> results;
    private final int heightOfLadder;
    private final List<LadderLine> ladderLines = new ArrayList<>();
    private final HashMap<String, String> matchedResult = new HashMap<>();

    public Ladder(InputDTO inputDTO) {
        people = inputDTO.getPeople();
        peopleSwapped = new ArrayList<>(people);
        results = inputDTO.getResults();
        heightOfLadder = inputDTO.getHeightOfLadder();
        buildLadder();
        playLadderGame();
    }

    private void buildLadder() {
        for(int i = 0 ; i < heightOfLadder ; i++) {
            LadderLine line = new LadderLine(people.size());
            ladderLines.add(line);
        }
    }

    private void playLadderGame() {
        for(LadderLine ladderLine : ladderLines) {
            swapLadderLine(ladderLine);
        }
        mapResults();
    }

    private void swapLadderLine(LadderLine ladderLine) {
        List<Boolean> points = ladderLine.getPoints();
        for (int i = 0 ; i < points.size() ; i++) {
            swapTwoPeople(i, points.get(i));
        }
    }

    private void swapTwoPeople(int index, Boolean isSwappable) {
        if (isSwappable) {
            Collections.swap(peopleSwapped,index,index+1);
        }
        return;
    }

    private void mapResults() {
        for (int i = 0 ; i < people.size() ; i++) {
            matchedResult.put(peopleSwapped.get(i),results.get(i));
        }
    }

    public List<String> getPeople() {
        return people;
    }

    public HashMap<String, String> getMatchedResult() {
        return matchedResult;
    }

    public List<String> getResults() {
        return results;
    }

    public List<LadderLine> getLadderLines() {
        return ladderLines;
    }
}