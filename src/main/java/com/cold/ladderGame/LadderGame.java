package com.cold.ladderGame;

public class LadderGame {

  public static void main(String[] args) {
    GameInfo gameInfo = new GameInfo();
    gameInfo.setValues();

    Ladder ladder = new Ladder(gameInfo.getWidth(), gameInfo.getHeight());
    ladder.printLadder();
  }
}
