package service;

import domain.ladder.Ladder;
import domain.ladder.LadderFrame;
import domain.ladder.LadderFrameLine;

import java.util.*;

public class LadderGameService {
    private List<String> users;
    private List<String> results;
    public LadderGameService(List<String> users, List<String> results){
        this.users = new ArrayList<>(users);
        this.results = results;
    }

    public void calculateResult(Ladder ladder) {
        for (LadderFrameLine line : ladder.getLines()){
            checkLine(line);
        }
    }

    private void checkLine(LadderFrameLine line){
        int frameLength = line.getFrames().size();
        for(int index = 0; index < frameLength; index++){
            checkFrame(line.getFrames().get(index), index);
        }
    }

    private void checkFrame(LadderFrame frame, int index) {
        if(frame == LadderFrame.BRIDGE){
            Collections.swap(users, index, index + 1);
        }
    }

    public String getResult(String target){
        return results.get(users.indexOf(target));
    }
}
