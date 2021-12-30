package main.java.ladder;

import main.java.ladder.domain.Ladder;
import main.java.ladder.domain.User;
import main.java.ladder.view.Engine;

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
