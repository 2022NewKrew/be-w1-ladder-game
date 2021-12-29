package controller;

import domain.ladder.Ladder;
import view.UserInput;
import view.UserOutput;

import java.util.List;

public class LadderGame {

    private static LadderGame INSTANCE;

    private final List<String> users;
    private final Ladder ladder;

    private LadderGame() {
        List<String> users = UserInput.getUserList();
        checkUsers(users);
        this.users = users;
        this.ladder = new Ladder(this.users.size(), UserInput.getLadderHeight());
    }

    public static synchronized LadderGame getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LadderGame();
        }
        return INSTANCE;
    }

    public void printLadder() {
        UserOutput.printLadderToConsole(ladder, users);
    }

    private void checkUsers(List<String> userList) {
        isNotEmptyList(userList);
        isLegalUsers(userList);
    }

    private void isLegalUsers(List<String> userList){
        if (userList.stream().anyMatch(userName-> userName.length() > 5)){
            throw new IllegalArgumentException("사람의 이름은 5글자 이내여야 합니다.");
        }
    }

    private void isNotEmptyList(List<String> userList) {
        if (userList.isEmpty()){
            throw new IllegalArgumentException("한명 이상의 사람을 입력해주세요.");
        }
    }

}
