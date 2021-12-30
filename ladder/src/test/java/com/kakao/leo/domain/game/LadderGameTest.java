package com.kakao.leo.domain.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderGameTest {

  @Test
  @DisplayName("run 정상")
  void run() {

    // given
    LadderGame ladderGame = new LadderGame();

    // when
    boolean isExceptionOccurred = false;
    try{
      ladderGame.run();
    }catch(Exception e) {
      isExceptionOccurred = true;
    }

    // then
    assertThat(isExceptionOccurred).isFalse();

  }
}