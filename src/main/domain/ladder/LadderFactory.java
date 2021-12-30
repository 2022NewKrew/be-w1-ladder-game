package main.domain.ladder;

public interface LadderFactory {

    Ladder createLadder(String[] players, String[] results, int height);
}
