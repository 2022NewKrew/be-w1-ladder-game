package com.kakao.domain.player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    private final int MAX_NAME_LENGTH = 5;
    private final String originalName = "jin";
    private final Name name = new Name(originalName);

    @DisplayName("이름은 비어있을 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    void constructor_Blank_Exception(String originalName) {
        assertThrows(IllegalArgumentException.class, () -> new Name(originalName));
    }

    @DisplayName("이름은 5글자를 초과할 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"jeeneee", "jin.jang"})
    void constructor_ExceedFive_Exception(String originalName) {
        assertThrows(IllegalArgumentException.class, () -> new Name(originalName));
    }

    @DisplayName("플레이어 이름을 생성한다.")
    @Test
    void constructor_Name_Success() {
        assertThat(name.getOriginalName()).isEqualTo(originalName);
    }

    @DisplayName("정제된 플레이어 이름은 5글자이다.")
    @Test
    void refine_Name_Success() {
        String refinedName = name.refine();
        assertThat(refinedName).hasSize(MAX_NAME_LENGTH);
    }
}