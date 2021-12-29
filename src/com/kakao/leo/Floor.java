package com.kakao.leo;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

/**
 * 사다리의 한 층을 나타내는 객체, 한 층의 Separator 생성 및 Separator 길이 활용을 담당.
 *
 * @author leo.jung
 * @since 1.0
 */
public class Floor implements Iterable<LadderCell> {

  public static final int DEFAULT_SEPARATOR_LENGTH = 5;
  private final List<LadderCell> floor;
  private final int separatorLength;
  private final Random random;

  private Floor(int width, int separatorLength) throws Exception {
    this.random = SecureRandom.getInstanceStrong();
    this.floor = new ArrayList<>();
    this.separatorLength = separatorLength;
    for (int i = 0; i < width; i++) {
      addCell(i, width - 1);
    }
  }


  public static Floor create(int width) throws Exception {
    return new Floor(width, DEFAULT_SEPARATOR_LENGTH);
  }


  public static Floor create(int width, int separatorLength) throws Exception {
    return new Floor(width, separatorLength);
  }


  private void addCell(int current, int lastIndex) {
    floor.add(LadderCell.LINE);
    if (current < lastIndex) {
      floor.add(getSeparator(current));
    }
  }


  private LadderCell getSeparator(int current) {
    if (isPrevSeparatorEmpty(current)) {
      return random.nextBoolean() ? LadderCell.SEPARATOR : LadderCell.EMPTY_SEPARATOR;
    }
    return LadderCell.EMPTY_SEPARATOR;
  }


  private boolean isPrevSeparatorEmpty(int current) {
    int prevIndex = current * 2 - 1;
    System.out.println(prevIndex);
    return prevIndex < 0 || floor.get(prevIndex) == LadderCell.EMPTY_SEPARATOR;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    floor.forEach(ladderCell -> appendCell(sb, ladderCell));
    return sb.toString();
  }


  private void appendCell(StringBuilder sb, LadderCell ladderCell) {
    if (ladderCell == LadderCell.LINE) {
      sb.append(ladderCell);
      return;
    }

    for (int i = 0; i < separatorLength; i++) {
      sb.append(ladderCell);
    }
  }


  @Override
  public Iterator<LadderCell> iterator() {
    return floor.iterator();
  }


  @Override
  public void forEach(Consumer<? super LadderCell> action) {
    floor.forEach(action);
  }

}
