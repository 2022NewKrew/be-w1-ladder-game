package com.cold.ladderGame.domain;

import com.cold.ladderGame.view.InputView;
import com.cold.ladderGame.view.OutputView;

public class Result {

  public static void checkResult(InputView inputView,
      OutputView outputView, Ladder ladder) throws Exception{

    while(true){
      inputView.selectUser();
      ladder.getGameResult(inputView.getSelectedUserIdx());
      outputView.printResult(inputView, ladder);
    }
  }
}

