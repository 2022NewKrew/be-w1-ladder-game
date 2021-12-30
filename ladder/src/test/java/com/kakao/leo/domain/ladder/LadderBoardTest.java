package com.kakao.leo.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.kakao.leo.domain.user.Participants;
import com.kakao.leo.domain.user.Person;
import com.kakao.leo.view.out.BufferedWriteManager;
import com.kakao.leo.view.out.WriteManager;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderBoardTest {

  @Test
  @DisplayName("create 생성 확인")
  void create() throws Exception {

    // given
    Ladder ladder = Ladder.of(7, 5);
    Participants participants = Participants.of(List.of(
        new Person("a"),
        new Person("b"),
        new Person("c")
    ));

    // when
    LadderBoard ladderBoardResult = LadderBoard.create(ladder, participants);

    // then
    assertThat(ladderBoardResult).isNotNull();

  }

  @Test
  @DisplayName("drawWith 정상 확인")
  void drawWith() throws Exception {

    // given
    Ladder ladder = Ladder.of(7, 5);
    Participants participants = Participants.of(List.of(
        new Person("a"),
        new Person("b"),
        new Person("c")
    ));
    LadderBoard ladderBoard = LadderBoard.create(ladder, participants);
    WriteManager writeManager = BufferedWriteManager.create();

    // when
    boolean isExceptionOccurred = false;
    try{
      ladderBoard.drawWith(writeManager);
    }catch(IOException e) {
      isExceptionOccurred = true;
    }

    // then
    assertThat(isExceptionOccurred).isFalse();

  }
}