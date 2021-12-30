package com.kakao.leo.domain.ladder;

import com.kakao.leo.domain.user.Participants;
import com.kakao.leo.view.in.BufferedReadManager;
import com.kakao.leo.view.in.ReadManager;
import com.kakao.leo.view.out.BufferedWriteManager;
import com.kakao.leo.view.out.WriteManager;

/**
 * LadderGame 객체로, Ladder 의 생성과 게임 진행 및 입출력 인터페이스를 관리.
 *
 * @author leo.jung
 * @since 1.0
 */
public class LadderGame {

  private final ReadManager readManager;
  private final WriteManager writeManager;
  private LadderBoard ladderBoard;

  public LadderGame() {
    this.readManager = BufferedReadManager.create();
    this.writeManager = BufferedWriteManager.create();
  }


  private void setupLadderBoard() throws Exception {
    Participants participants = readManager.getParticipants();
    int ladderHeight = readManager.getLadderHeight();
    Ladder ladder = Ladder.of(participants.size(), ladderHeight);
    this.ladderBoard = LadderBoard.create(ladder, participants);
  }


  public void run() throws Exception {

    if (ladderBoard == null) {
      setupLadderBoard();
    }

    ladderBoard.drawWith(writeManager);

  }

}
