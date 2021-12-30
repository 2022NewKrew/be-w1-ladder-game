package com.kakao.leo.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FloorTest {

  @Test
  @DisplayName("Floor 생성1")
  void create() throws Exception {

    // given
    int width = 7;

    // when
    Floor floor = Floor.create(width);
    Field field1 = Floor.class.getDeclaredField("separatorLength");
    field1.setAccessible(true);
    int separatorLengthResult = (int) field1.get(floor);
    Field field2 = Floor.class.getDeclaredField("floor");
    field2.setAccessible(true);
    List<LadderCell> floorResult = (List<LadderCell>) field2.get(floor);

    // then
    assertThat(floor).isNotNull();
    assertThat(separatorLengthResult).isEqualTo(Floor.DEFAULT_SEPARATOR_LENGTH);
    assertThat(floorResult).isNotNull();
    assertThat(floorResult.size()).isEqualTo(width * 2 - 1);

  }

  @Test
  @DisplayName("Floor 생성2")
  void testCreate() throws Exception {

    // given
    int width = 7;
    int separatorLength = 8;

    // when
    Floor floor = Floor.create(width, separatorLength);
    Field field1 = Floor.class.getDeclaredField("separatorLength");
    field1. setAccessible(true);
    int separatorLengthResult = (int) field1.get(floor);
    Field field2 = Floor.class.getDeclaredField("floor");
    field2.setAccessible(true);
    List<LadderCell> floorResult = (List<LadderCell>) field2.get(floor);

    // then
    assertThat(floor).isNotNull();
    assertThat(separatorLengthResult).isEqualTo(separatorLength);
    assertThat(floorResult).isNotNull();
    assertThat(floorResult.size()).isEqualTo(width * 2 - 1);

  }

  @Test
  @DisplayName("toString 동작")
  void testToString() throws Exception {

    // given
    int width = 7;
    Floor floor = Floor.create(width);

    // when
    String toStringResult = floor.toString();

    // then
    assertThat(toStringResult.length()).isEqualTo(width + (width - 1) * Floor.DEFAULT_SEPARATOR_LENGTH);

  }

  @Test
  @DisplayName("iterator 반환")
  void iterator() throws Exception {

    // given
    int width = 7;
    Floor floor = Floor.create(width);

    // when
    Iterator<LadderCell> iteratorResult = floor.iterator();

    // then
    assertThat(iteratorResult.hasNext()).isTrue();

  }

  @Test
  @DisplayName("forEach 동작")
  void forEach() throws Exception {

    // given
    int width = 7;
    Floor floor = Floor.create(width);
    Field field = Floor.class.getDeclaredField("floor");
    field.setAccessible(true);
    List<LadderCell> floorResult = (List<LadderCell>) field.get(floor);
    StringBuilder sbExpect = new StringBuilder();
    StringBuilder sbResult = new StringBuilder();

    // when
    floorResult.forEach(sbExpect::append);
    floor.forEach(sbResult::append);

    // then
    assertThat(sbResult.toString()).isEqualTo(sbExpect.toString());

  }

  @Test
  @DisplayName("연속한 Separator 생성 방지 확인")
  void testSeparatorValid() throws Exception {

    // given
    int testCount = 1000;
    int width = 1000;

    // when
    Floor[] floors = new Floor[testCount];
    for(int i = 0; i < testCount; i++) {
      floors[i] = Floor.create(width);
    }

    // then
    for(Floor floor : floors) {
      Field field = Floor.class.getDeclaredField("floor");
      field.setAccessible(true);
      List<LadderCell> ladderCells = (List<LadderCell>) field.get(floor);
      int size = ladderCells.size();
      for(int i = 0; i < size; i++) {
        if(ladderCells.get(i) == LadderCell.SEPARATOR && i - 2 >= 0) {
          assertThat(ladderCells.get(i - 1)).isNotEqualTo(LadderCell.SEPARATOR);
        }
      }
    }

  }

}