package com.cold.ladderGame;

import com.cold.ladderGame.domain.Ladder;
import com.cold.ladderGame.view.InputView;
import com.cold.ladderGame.view.OutputView;

public class LadderGame {

  public static void main(String[] args) throws Exception{
    InputView inputView = new InputView();
    inputView.setValues();

    Ladder ladder = new Ladder(inputView.getWidth(), inputView.getHeight());

    OutputView outputView = new OutputView();
    outputView.printLadder(ladder, inputView.getUsers());
  }
}
