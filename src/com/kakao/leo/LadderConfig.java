package com.kakao.leo;

/**
 * Ladder 의 여러 속성정보 객체
 * 다양한 Ladder 의 속성값들을 하나의 객체로서 관리한다.
 *
 * @author leo.jung
 * @since 1.0
 */
public class LadderConfig {

  private int numberOfPeople;
  private int height;

  private LadderConfig(int numberOfPeople, int height) {
    this.numberOfPeople = numberOfPeople;
    this.height = height;
  }

  public static LadderConfig of (int numberOfPeople, int height) {
    return new LadderConfig(numberOfPeople, height);
  }

  public int getNumberOfPeople() {
    return numberOfPeople;
  }

  public void setNumberOfPeople(int numberOfPeople) {
    this.numberOfPeople = numberOfPeople;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }
}
