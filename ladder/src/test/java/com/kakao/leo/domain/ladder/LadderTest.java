package com.kakao.leo.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.kakao.leo.view.out.BufferedWriteManager;
import com.kakao.leo.view.out.WriteManager;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

  @Test
  @DisplayName("of 객체 생성")
  void of() throws Exception {

    // given
    int width = 5;
    int height = 7;

    // when
    Ladder ladderResult = Ladder.of(width, height);
    Field field = Ladder.class.getDeclaredField("floors");
    field.setAccessible(true);
    List<Floor> floorsResult = (List<Floor>) field.get(ladderResult);
    Floor floorResult = floorsResult.get(0);
    Field field1 = Floor.class.getDeclaredField("floor");
    field1.setAccessible(true);
    List<LadderCell> ladderCellsResult = (List<LadderCell>) field1.get(floorResult);

    // then
    assertThat(ladderResult).isNotNull();
    assertThat(floorsResult).isNotNull();
    assertThat(floorsResult.size()).isEqualTo(height);
    assertThat(ladderCellsResult.size()).isEqualTo(width * 2 - 1);

  }

  @Test
  @DisplayName("drawWith 확인")
  void drawWith() throws Exception {

    // given
    int width = 5;
    int height = 7;
    Ladder ladder = Ladder.of(width, height);
    WriteManager writeManager = BufferedWriteManager.create();

    // when
    boolean isExceptionOccurred = false;
    try{
      ladder.drawWith(writeManager);
    }catch(IOException e) {
      isExceptionOccurred = true;
    }

    // then
    assertThat(isExceptionOccurred).isFalse();

  }

  @Test
  @DisplayName("toString 확인")
  void testToString() throws Exception {

    // given
    int width = 5;
    int height = 7;
    Ladder ladder = Ladder.of(width, height);

    // when
    String toStringResult = ladder.toString();

    // then
    assertThat(toStringResult.length()).isEqualTo((width + (width - 1) * Floor.DEFAULT_SEPARATOR_LENGTH) * height + height);

  }
}