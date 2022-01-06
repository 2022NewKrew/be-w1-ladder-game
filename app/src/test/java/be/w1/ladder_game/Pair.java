package be.w1.ladder_game;

public class Pair {
    public String playersName;
    public int ladderHeight;

    public Pair(String playersName, int ladderHeight) {
        this.playersName = playersName;
        this.ladderHeight = ladderHeight;
    }

    public String getPlayersName() {
        return playersName;
    }

    public int getLadderHeight() {
        return ladderHeight;
    }
}

