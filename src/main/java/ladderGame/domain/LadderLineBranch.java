package ladderGame.domain;

public class LadderLineBranch {
    private boolean connect;

    public LadderLineBranch(boolean connect) {
        this.connect = connect;
    }

    public boolean isConnect() {
        return connect;
    }
}
