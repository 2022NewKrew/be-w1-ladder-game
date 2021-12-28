package com.kakao.leo;

public class App {

  public void run() throws Exception {
    Ladder ladder = Ladder.ofInput(ConsoleInputManager.create());
    ladder.draw(ConsoleWriteManager.create());
  }

}
