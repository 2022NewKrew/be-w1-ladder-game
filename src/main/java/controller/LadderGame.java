package controller;

<<<<<<< HEAD
import dao.LadderDAO;
import domain.gameResult.GameResultPrecondition;
=======
>>>>>>> 05c0cd8 (리뷰받은 내용 중 gradle관련 수정)
import domain.ladder.Ladder;
import view.UserInput;
import view.UserOutput;

import java.util.List;

public class LadderGame {
<<<<<<< HEAD

    private static LadderGame INSTANCE;
    private final List<String> users;
    private final Ladder ladder;


    private LadderGame() {
        List<String> users = UserInput.getUserList();
=======
    private static final int MAX_LENGTH = 5;
    private static LadderGame INSTANCE;

    private final List<String> users;
    private final Ladder ladder;

    private LadderGame() {
        List<String> users = UserInput.getUserList();
        LadderGamePrecondition.checkUsers(users, MAX_LENGTH);
>>>>>>> 05c0cd8 (리뷰받은 내용 중 gradle관련 수정)
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

<<<<<<< HEAD
=======

>>>>>>> 05c0cd8 (리뷰받은 내용 중 gradle관련 수정)
}
