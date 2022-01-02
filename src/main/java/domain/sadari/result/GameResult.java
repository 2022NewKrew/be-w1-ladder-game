package domain.sadari.result;

import domain.user.User;

public class GameResult {

    private final User user;
    private final SadariResult sadariResult;

    public GameResult(User user, SadariResult sadariResult) {
        this.user = user;
        this.sadariResult = sadariResult;
    }

    public String getUserName() {
        return user.getName();
    }

    public String getResultName() {
        return sadariResult.getName();
    }

    public void print() {
        user.print();
        System.out.print(" : ");
        sadariResult.print();
    }
}
