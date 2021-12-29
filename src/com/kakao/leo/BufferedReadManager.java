package com.kakao.leo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * BufferedReader 로 입력을 받아 LadderConfig 를 세팅하는 InputManager 구현체 유저에게 사다리에 대한 정보를 요청, 유효하지 않은 입력값(음수,
 * 문자 등) 넘어올 시 반복해서 정보 요청
 *
 * @author leo.jung
 * @since 1.0
 */
public class BufferedReadManager implements ReadManager {

  private final BufferedReader reader;
  private final BufferedWriter writer;

  private BufferedReadManager() {
    this.reader = new BufferedReader(new InputStreamReader(System.in));
    this.writer = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  public static ReadManager create() {
    return new BufferedReadManager();
  }


  @Override
  public LadderConfig getOptions() throws IOException {
    List<Person> people = getPeopleFromReader();
    int height = getHeightFromReader();
    return LadderConfig.of(people, height);
  }


  private List<Person> getPeopleFromReader() throws IOException {
    System.out.println(INPUT_PEOPLE_MENT);
    List<Person> people = null;
    while (people == null) {
      people = parsePeopleFromReader();
    }
    return people;
  }


  private int getHeightFromReader() throws IOException {
    println(INPUT_HEIGHT_MENT);
    int height = -1;
    while (height < 0) {
      height = getUnsignedIntegerFromReader();
    }
    return height;
  }


  private List<Person> parsePeopleFromReader() throws IOException {
    String input = reader.readLine();
    try {
      return splitByDelimiter(input)
          .stream()
          .map(Person::new)
          .collect(Collectors.toList());
    }catch(Exception e) {
      println(WRONG_INPUT_PEOPLE_MENT + " [" + input + "]");
    }
    return null;
  }


  private int getUnsignedIntegerFromReader() throws IOException {
    String input = reader.readLine();
    try {
      return Integer.parseUnsignedInt(input.strip());
    } catch (Exception e) {
      println(WRONG_INPUT_HEIGHT_MENT + " [" + input + "]");
    }
    return -1;
  }


  private void println(String str) throws IOException {
    writer.write(str);
    writer.newLine();
    writer.flush();
  }

}
