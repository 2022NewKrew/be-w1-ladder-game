package com.kakao.leo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * BufferedWriter 를 통해 String 객체를 출력하는 WriteManager 구현체
 *
 * @author leo.jung
 * @since 1.0
 */
public class BufferedWriteManager implements WriteManager {

  private final BufferedWriter writer;

  private BufferedWriteManager() {
    this.writer = new BufferedWriter(new OutputStreamWriter(System.out));
  }


  public static BufferedWriteManager create() {
    return new BufferedWriteManager();
  }


  @Override
  public void draw(String str) throws IOException {
    writer.write(str);
    writer.flush();
  }
}
