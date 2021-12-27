package com.kakao.leo;

import java.util.List;

public class LadderConfig {

  private int count;
  private int height;

  private LadderConfig(int count, int height) {
    this.count = count;
    this.height = height;
  }

  public static LadderConfig of (int count, int height) {
    return new LadderConfig(count, height);
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }
}
