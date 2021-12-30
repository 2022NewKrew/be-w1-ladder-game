package com.kakao.leo;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Scanner 로 입력을 받아 LadderConfig 를 세팅하는 InputManager 구현체 유저에게 사다리에 대한 정보를 요청, 유효하지 않은 입력값(음수, 문자 등)
 * 넘어올 시 예외 발생 후 종료 됨.
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
  public Participants getParticipants() {
    System.out.println(INPUT_PEOPLE_MENT);
    String input = scanner.nextLine();
    List<Person> people = splitByDelimiter(input)
        .stream()
        .map(Person::new)
        .collect(Collectors.toList());
    return Participants.of(people);
  }


  @Override
  public int getLadderHeight() {
    System.out.println(INPUT_HEIGHT_MENT);
    return scanner.nextInt();
  }

}
