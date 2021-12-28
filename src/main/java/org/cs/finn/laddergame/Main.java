package org.cs.finn.laddergame;

public class Main {

    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame();

        ladderGame.requestParameter();
        ladderGame.createLadder();
        ladderGame.printLadder();
        ladderGame.closeGame();
    }
}
