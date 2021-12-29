package com.kakao.leo;

/**
 * Ladder 좌표의 한 칸을 Cell 로 정의. LINE, SEPARATOR, EMPTY_SEPARATOR 로 나눈다.
 *
 * @author leo.jung
 * @since 1.0
 */
public enum LadderCell {

  LINE('|'),
  SEPARATOR('-'),
  EMPTY_SEPARATOR(' ');

  final private Character character;

  LadderCell(Character character) {
    this.character = character;
  }

  @Override
  public String toString() {
    return String.valueOf(character);
  }
}
