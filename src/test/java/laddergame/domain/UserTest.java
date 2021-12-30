package laddergame.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

    @DisplayName("User 이름 get 메소드 테스트")
    @Test
    void getName() {
        // Given
        User user = new User("test");

        // When
        String result = user.getName();

        // Then
        Assertions.assertEquals("test", result);
    }

    @DisplayName("User 생성 - 이름이 5자 이하인 경우")
    @Test
    void makeUserWith4LengthName() {
        // Given
        User user = new User("12345");

        // When
        String result = user.getName();

        // Then
        Assertions.assertEquals("12345", result);
    }

    @DisplayName("User 생성 - 이름이 5자 초과인 경우")
    @Test
    void makeUserWith5LengthName() {

        // Given // When // Then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            User user = new User("123456");
        });
    }
}