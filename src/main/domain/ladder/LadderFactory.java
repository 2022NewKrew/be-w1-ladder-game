package main.domain.ladder;

public interface LadderFactory {

    Ladder createLadder(String[] playerNames, String[] results, int height);
}
