package laddergame.domain;

import laddergame.view.GameView;
import java.util.List;

public class Game {
    private List<String> users;
    private Ladder ladder;

    public void start(){
        users = GameView.inputUsers();
        ladder = new Ladder(users.size(), GameView.inputLadderHeight());
        GameView.printLadderWithUsers(ladder, users);
    }
}
