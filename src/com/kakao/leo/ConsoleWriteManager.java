package com.kakao.leo;

/**
 * System.out 을 통해 String 객체를 출력하는 WriteManager 구현체
 *
 * @author leo.jung
 * @since 1.0
 */
public class ConsoleWriteManager implements WriteManager {

  private ConsoleWriteManager() {}

  public static ConsoleWriteManager create() {
    return new ConsoleWriteManager();
  }


  @Override
  public void draw(String str) {
    System.out.println(str);
  }

}
