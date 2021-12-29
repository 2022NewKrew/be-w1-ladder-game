package laddergame;

import laddergame.view.View;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {

    private final View view;
    private Ladder ladder;
    private List<User> users;

    public LadderGame(View view) {
        this.view = view;
    }

    public void run() throws Exception {
        List<String> userNameList = view.readUserName();
        makeUsers(userNameList);

        Integer ladderCount = view.readLadderCount();
        makeLadder(getUserCount(), ladderCount);

        view.printLadderBoard(ladder, users);
    }

    private void makeLadder(int userCount, int ladderCount) {
        this.ladder = new Ladder(userCount, ladderCount);
    }

    private void makeUsers(List<String> splitUser) {

        this.users = splitUser.stream()
                .map(User::new)
                .collect(Collectors.toList());
    }

    private Integer getUserCount() {
        return users.size();
    }
}
