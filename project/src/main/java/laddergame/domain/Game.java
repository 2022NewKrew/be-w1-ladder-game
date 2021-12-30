package laddergame.domain;

import laddergame.view.GameView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private List<String> users;
    private List<String> targets;
    private Ladder ladder;
    private Map<String,String> result;

    public void start(){
        users = GameView.inputUsers();
        targets = GameView.inputTargets();
        ladder = new Ladder(users.size(), GameView.inputLadderHeight());
        GameView.printLadderWithLabels(ladder, users, targets);
    }

    public Map<String,String> findResult(){
        Map<String,String> result = new HashMap<String,String>();
        for(int i=0; i<users.size(); i++){
            result.put(users.get(i), targets.get(ladder.findResultPosition(i)));
        }
        return result;
    }
}
