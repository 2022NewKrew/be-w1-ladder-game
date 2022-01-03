package ladder;

import ladder.domain.Ladder;
import ladder.domain.Result;
import ladder.domain.User;
import ladder.view.Engine;

import java.util.List;

public class Main {
    static final Engine engine = new Engine();

    public static void main(String[] args) {
        final List<User> users = engine.inputUsers();
        final List<Result> results = engine.inputResult();
        final int ladderHeight = engine.inputLadderHeight();
        final Ladder ladder = new Ladder(users.size(), ladderHeight);
        engine.printUsers();
        ladder.print();
        engine.printResults();
        engine.run(ladder, users, results);
        engine.inputUserResult();
    }
}
