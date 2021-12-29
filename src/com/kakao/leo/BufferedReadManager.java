package com.kakao.leo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * BufferedReader 로 입력을 받아 LadderConfig 를 세팅하는 InputManager 구현체
 * 유저에게 사다리에 대한 정보를 요청, 유효하지 않은 입력값(음수, 문자 등) 넘어올 시 반복해서 정보 요청
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
    int numberOfPeople = getNumberOfPeopleFromReader();
    int height = getHeightFromReader();
    return LadderConfig.of(numberOfPeople, height);
  }


  private int getNumberOfPeopleFromReader() throws IOException {
    println("참여할 사람은 몇 명인가요?");
    int numberOfPeople = -1;
    while(numberOfPeople < 0) {
      numberOfPeople = getUnsignedIntegerFromReader();
    }
    return numberOfPeople;
  }


  private int getHeightFromReader() throws IOException {
    println("최대 사다리 높이는 몇 개인가요?");
    int height = -1;
    while(height < 0) {
      height = getUnsignedIntegerFromReader();
    }
    return height;
  }


  private int getUnsignedIntegerFromReader() throws IOException {
    String input = reader.readLine();
    try{
      return Integer.parseUnsignedInt(input.strip());
    }catch(Exception e) {
      println("유효한 입력값이 아닙니다. 숫자를 입력하세요. [" + input + "]\n");
    }
    return -1;
  }


  private void println(String str) throws IOException {
    writer.write(str);
    writer.newLine();
    writer.flush();
  }

}
