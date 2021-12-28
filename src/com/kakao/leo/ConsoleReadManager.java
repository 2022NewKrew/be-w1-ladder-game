package com.kakao.leo;

import java.util.Scanner;

/**
 * Scanner 로 입력을 받아 LadderConfig 를 세팅하는 InputManager 구현체
 *
 * @author leo.jung
 * @since 1.0
 */
public class ConsoleReadManager implements ReadManager {

  private final Scanner scanner;

  private ConsoleReadManager() {
    this.scanner = new Scanner(System.in);
  }

  public static ConsoleReadManager create() {
    return new ConsoleReadManager();
  }


  @Override
  public LadderConfig getOptions() {
    int numberOfPeople = getNumberOfPeopleFromScanner();
    int height = getHeightFromScanner();
    return LadderConfig.of(numberOfPeople, height);
  }


  private int getNumberOfPeopleFromScanner() {
    System.out.println("참여할 사람은 몇 명인가요?");
    return scanner.nextInt();
  }


  private int getHeightFromScanner() {
    System.out.println("최대 사다리 높이는 몇 개인가요?");
    return scanner.nextInt();
  }

}
