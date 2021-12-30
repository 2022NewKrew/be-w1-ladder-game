package com.kakao.leo.view.in;

import static javax.swing.UIManager.get;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.kakao.leo.domain.user.Participants;
import com.kakao.leo.domain.user.Person;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BufferedReadManagerTest {

  @Test
  @DisplayName("create 생성 정상")
  void create() throws IllegalAccessException {

    // given

    // when
    ReadManager bufferedReadManager = BufferedReadManager.create();
    Field[] fields = BufferedReadManager.class.getDeclaredFields();

    // then
    assertThat(bufferedReadManager).isNotNull();
    assertThat(bufferedReadManager).isExactlyInstanceOf(BufferedReadManager.class);
    for(Field field : fields) {
      field.setAccessible(true);
      Object var = field.get(bufferedReadManager);
      assertThat(var).isNotNull();
    }

  }

  @Test
  @DisplayName("getParticipants 글자수 체크 확인")
  void getParticipants() throws IOException, NoSuchFieldException, IllegalAccessException {

    // given
    String input = "leo, abcdef, abc \n leo, abc, alpha, beta \n";
    OutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    BufferedReadManager bufferedReadManager = BufferedReadManager.create();

    // when
    Participants participants = bufferedReadManager.getParticipants();
    Field field = Participants.class.getDeclaredField("participants");
    field.setAccessible(true);
    List<Person> participantsList = (List<Person>) field.get(participants);

    // then
    assertThat(participantsList.get(0).getName()).isEqualTo("leo");
    assertThat(participantsList.get(1).getName()).isEqualTo("abc");
    assertThat(participantsList.get(2).getName()).isEqualTo("alpha");
    assertThat(participantsList.get(3).getName()).isEqualTo("beta");
    assertThat(out.toString()).contains(ReadManager.WRONG_INPUT_PEOPLE_MENT);

  }

  @Test
  @DisplayName("getHeight 유효성 체크 확인")
  void getLadderHeight() throws IOException {

    // given
    String input = "alphabet \n 5 \n";
    OutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);
    BufferedReadManager bufferedReadManager = BufferedReadManager.create();

    // when
    int ladderHeight = bufferedReadManager.getLadderHeight();

    // then
    assertThat(ladderHeight).isEqualTo(5);
    assertThat(out.toString()).contains(ReadManager.WRONG_INPUT_HEIGHT_MENT);

  }
}