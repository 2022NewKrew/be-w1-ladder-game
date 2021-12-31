package ladder;

import ladder.domain.Ladder;
import ladder.domain.User;
import ladder.view.Engine;

import java.util.List;

public class Main {
    static final Engine engine = new Engine();

    public static void main(String[] args) {
        final List<User> users = engine.inputUsers();
        final int ladderHeight = engine.inputLadderHeight();
        final Ladder ladder = new Ladder(users.size(), ladderHeight);
        engine.printUsers(users);
        engine.showLadder(ladder);
    }
}
