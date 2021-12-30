package com.yapark97.laddergame;

import com.yapark97.laddergame.ladder.LadderGame;

public class Main {
    public static void main(String[] args){
        LadderGame ladderGame = new LadderGame();

        try {
            ladderGame.initGame();
            ladderGame.drawLadder();
        } catch (Exception e) {
            System.err.println("exception 발생");
            System.err.println(e.getMessage());
        }
    }
}
