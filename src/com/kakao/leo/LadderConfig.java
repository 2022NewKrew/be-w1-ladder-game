package com.kakao.leo;

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
