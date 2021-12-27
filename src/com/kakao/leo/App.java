package com.kakao.leo;

public class App {

  public void run() {
    Ladder ladder = Ladder.ofInput(ConsoleInputManager.create());
    ladder.draw(ConsoleWriteManager.create());
  }

}
