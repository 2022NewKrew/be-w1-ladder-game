package com.kakao.leo;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {

  private final List<List<Character>> floors;
  private final Random random;

  private Ladder() throws Exception {
    this.floors = new ArrayList<>();
    this.random = SecureRandom.getInstanceStrong();
  }


  private Ladder(LadderConfig config) throws Exception {
    this();
    setFloors(config);
  }


  public static Ladder ofInput(InputManager inputManager) throws Exception {
    return Ladder.of(inputManager.getOptions());
  }


  public static Ladder of(LadderConfig config) throws Exception {
    return new Ladder(config);
  }


  public void draw() {
    draw(ConsoleWriteManager.create());
  }


  public void draw(WriteManager writeManager) {
    writeManager.draw(toString());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    floors.forEach(floor -> {
      floor.forEach(sb::append);
      sb.append('\n');
    });
    return sb.toString();
  }


  private void setFloors(LadderConfig config) {
    int height = config.getHeight();
    int count = config.getCount();
    for(int i = 0; i < height; i++) {
      floors.add(createFloor(count));
    }
  }


  private List<Character> createFloor(int count) {
    List<Character> floor = new ArrayList<>();
    for(int i = 0; i < count; i++) {
      addCell(floor, i, count - 1);
    }
    return floor;
  }


  private void addCell(List<Character> floor, int current, int lastIndex) {
    floor.add('|');
    if(current < lastIndex) {
      floor.add(getSeparator());
    }
  }


  private Character getSeparator() {
    return random.nextBoolean() ? ' ' : '-';
  }

}
