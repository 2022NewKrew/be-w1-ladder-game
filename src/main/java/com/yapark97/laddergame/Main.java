package com.yapark97.laddergame;

public class Main {
    public static void main(String[] args){
        LadderGame ladderGame = new LadderGame();

        try {
            ladderGame.initGame();
            ladderGame.showStatus();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
