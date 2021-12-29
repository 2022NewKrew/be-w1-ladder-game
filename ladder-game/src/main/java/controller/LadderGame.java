package controller;

import domain.ladder.Ladder;
import view.UserInput;
import view.UserOutput;

import java.util.List;

public class LadderGame {

    public static LadderGame INSTANCE;

    private final List<String> userList;
    private final Ladder ladder;

    private LadderGame() {
        List<String> userList = UserInput.getUserList();
        checkUserList(userList);
        this.userList = userList;
        this.ladder = new Ladder(userList.size(), UserInput.getLadderHeight());
    }

    public static synchronized LadderGame getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LadderGame();
        }
        return INSTANCE;
    }

    public void printLadder() {
        UserOutput.printLadderToConsole(ladder, userList);
    }

    private void checkUserList(List<String> userList) {
        if(userList.stream().filter(user->user.length() <=5).toList().size() != userList.size()){
            throw new IllegalArgumentException("사람의 이름은 5글자 이내여야 합니다.");
        }
    }

}
