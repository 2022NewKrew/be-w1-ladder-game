package com.kakao.leo;

import java.io.IOException;

public class LadderBoard implements Drawable {

  private final Ladder ladder;
  private final Participants participants;

  private LadderBoard(Ladder ladder, Participants participants) {
    this.ladder = ladder;
    this.participants = participants;
  }

  public static LadderBoard create(Ladder ladder, Participants participants) {
    return new LadderBoard(ladder, participants);
  }

  public void drawWith(WriteManager writeManager) throws IOException {
    participants.drawWith(writeManager);
    ladder.drawWith(writeManager);
  }

}
