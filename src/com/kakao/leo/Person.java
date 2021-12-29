package com.kakao.leo;

/**
 * 참여자의 단일 객체, 이름 값만 보관한다.
 *
 * @author leo.jung
 * @since 1.0
 */
public class Person {

  private String name;

  public Person(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
