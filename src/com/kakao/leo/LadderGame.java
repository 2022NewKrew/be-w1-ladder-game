package com.kakao.leo;

/**
 * LadderGame 객체로, Ladder 의 생성과 게임 진행 및 입출력 인터페이스를 관리.
 *
 * @author leo.jung
 * @since 1.0
 */
public class LadderGame {

  private final ReadManager readManager;
  private final WriteManager writeManager;

  public LadderGame() {
    this.readManager = BufferedReadManager.create();
//    this.readManager = ConsoleReadManager.create();
    this.writeManager = BufferedWriteManager.create();
  }

  public void run() throws Exception {
    Ladder ladder = Ladder.ofInput(readManager);
    ladder.drawWith(writeManager);
  }

}
