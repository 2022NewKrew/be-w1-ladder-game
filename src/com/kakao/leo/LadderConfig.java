package com.kakao.leo;

import java.util.List;

/**
 * Ladder 의 여러 속성정보 객체
 * 다양한 Ladder 의 속성값들을 하나의 객체로서 관리한다.
 *
 * @author leo.jung
 * @since 1.0
 */
public class LadderConfig {

  private List<Person> people;
  private int height;

  private LadderConfig(List<Person> people, int height) {
    this.people = people;
    this.height = height;
  }

  public static LadderConfig of(Person[] people, int height) {
    return of(List.of(people), height);
  }

  public static LadderConfig of (List<Person> people, int height) {
    return new LadderConfig(people, height);
  }

  public List<Person> getPeople() {
    return people;
  }

  public void setPeople(List<Person> people) {
    this.people = people;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }
}
