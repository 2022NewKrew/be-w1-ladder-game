package com.kakao.leo;

import java.util.Scanner;

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
