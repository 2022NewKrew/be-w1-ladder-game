package com.kakao.leo.domain.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PersonTest {

  @Test
  @DisplayName("getter 정상")
  void getName() {

    // given
    String name = "aa";
    Person person = new Person(name);

    // when
    String getNameResult = person.getName();

    // then
    assertThat(getNameResult).isEqualTo(name);

  }

  @Test
  @DisplayName("setter 정상")
  void setName() throws NoSuchFieldException, IllegalAccessException {

    // given
    String initialName = "aa";
    String updateName = "bb";
    Person person = new Person(initialName);

    // when
    person.setName(updateName);
    Field field = Person.class.getDeclaredField("name");
    field.setAccessible(true);
    String setNameResult = (String) field.get(person);

    // then
    assertThat(setNameResult).isEqualTo(updateName);

  }
}