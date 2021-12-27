package com.kakao.leo;

import java.util.Scanner;

public class ConsoleInputManager implements InputManager {

  private final Scanner scanner;

  private ConsoleInputManager() {
    this.scanner = new Scanner(System.in);
  }

  public static ConsoleInputManager create() {
    return new ConsoleInputManager();
  }

  @Override
  public LadderConfig getOptions() {
    int count = getCountFromScanner();
    int height = getHeightFromScanner();
    return LadderConfig.of(count, height);
  }

  private int getCountFromScanner() {
    System.out.println("참여할 사람은 몇 명인가요?");
    return scanner.nextInt();
  }

  private int getHeightFromScanner() {
    System.out.println("최대 사다리 높이는 몇 개인가요?");
    return scanner.nextInt();
  }

}
