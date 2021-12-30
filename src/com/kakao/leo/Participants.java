package com.kakao.leo;

import java.io.IOException;
import java.util.List;

/**
 * List<Person> 의 일급컬렉션 객체, 참여자 집합을 의미
 *
 * @author leo.jung
 * @since 1.0
 */
public class Participants implements Drawable {

  private final List<Person> participants;

  private Participants(List<Person> participants) {
    this.participants = participants;
  }


  public static Participants of(List<Person> participants) {
    return new Participants(participants);
  }


  @Override
  public void drawWith(WriteManager writeManager) throws IOException {
    StringBuilder sb = new StringBuilder();
    for (Person person : participants) {
      sb.append(person.getName()).append("\t");
    }
    sb.append("\n");
    writeManager.draw(sb.toString());
  }


  public int size() {
    return participants.size();
  }

}
