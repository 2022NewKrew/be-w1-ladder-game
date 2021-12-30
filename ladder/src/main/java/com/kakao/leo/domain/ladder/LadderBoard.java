package com.kakao.leo.domain.ladder;

import com.kakao.leo.domain.user.Participants;
import com.kakao.leo.view.in.Drawable;
import com.kakao.leo.view.out.WriteManager;
import java.io.IOException;

/**
 * 사다리와 참여자로 이루어진 사다리 보드 객체. 사다리 - 참여자 간 도메인을 의존관계로 묶지 말고 LadderBoard 객체를 상위에 두어 도메인을 따로 관리
 *
 * @author leo.jung
 * @since 1.0
 */
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
