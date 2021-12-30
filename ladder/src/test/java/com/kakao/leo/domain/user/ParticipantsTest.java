package com.kakao.leo.domain.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.kakao.leo.view.out.BufferedWriteManager;
import com.kakao.leo.view.out.WriteManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParticipantsTest {

  @Test
  @DisplayName("of 생성 정상")
  void of() throws NoSuchFieldException, IllegalAccessException {

    // given
    List<Person> participants = Arrays.asList(
        new Person("a"),
        new Person("b"),
        new Person("c")
    );

    // when
    Participants participantsResult = Participants.of(participants);
    Field field = Participants.class.getDeclaredField("participants");
    field.setAccessible(true);
    List<Person> participantsListResult = (List<Person>) field.get(participantsResult);

    // then
    assertThat(participantsListResult).isEqualTo(participants);

  }

  @Test
  @DisplayName("draw 정상")
  void drawWith() {

    // given
    List<Person> participantList = Arrays.asList(
        new Person("a"),
        new Person("b"),
        new Person("c")
    );
    Participants participants = Participants.of(participantList);
    WriteManager writeManager = BufferedWriteManager.create();

    // when
    boolean isExceptionOccurred = false;
    try{
      participants.drawWith(writeManager);
    }catch(IOException e) {
      isExceptionOccurred = true;
    }

    // then
    assertThat(isExceptionOccurred).isFalse();

  }

  @Test
  @DisplayName("size 정상")
  void size() {

    // given
    List<Person> participantList = Arrays.asList(
        new Person("a"),
        new Person("b"),
        new Person("c")
    );
    Participants participants = Participants.of(participantList);

    // when
    int sizeResult = participants.size();

    // then
    assertThat(sizeResult).isEqualTo(participantList.size());

  }
}