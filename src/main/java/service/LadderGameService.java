package service;

import domain.ladder.Ladder;
import domain.ladder.LadderFrame;
import domain.ladder.LadderFrameLine;
import dto.LadderDTO;

import java.util.*;
import java.util.stream.Collectors;

public class LadderGameService {
    private final List<String> users;
    private final List<String> results;

    public LadderGameService(List<String> users, List<String> results) {
        this.users = new ArrayList<>(users);
        this.results = results;
    }

    public void calculateResult(LadderDTO ladder) {
        for (LadderFrameLine line : ladder.getLines()) {
            checkLine(line);
        }
    }

    public String getTargetResult(String target) {
        return results.get(users.indexOf(target));
    }

    public List<Map.Entry<String,String>> getAllResult() {
        List<Map.Entry<String,String>> result = new ArrayList<>();
        for(int i = 0 ; i < users.size(); i++){
            result.add(new AbstractMap.SimpleEntry<>(users.get(i), results.get(users.indexOf(users.get(i)))));
        }
        return result.stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
    }

    private void checkLine(LadderFrameLine line) {
        int frameLength = line.getFrames().size();
        for (int index = 0; index < frameLength; index++) {
            checkFrame(line.getFrames().get(index), index);
        }
    }

    private void checkFrame(LadderFrame frame, int index) {
        if (frame == LadderFrame.BRIDGE) {
            Collections.swap(users, index, index + 1);
        }
    }
}
