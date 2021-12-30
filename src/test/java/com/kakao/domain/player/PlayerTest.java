package com.kakao.domain.player;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {

    private final int MAX_NAME_LENGTH = 5;

    @DisplayName("정제된 플레이어 이름을 가져올 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"jin", "kakao"})
    void getRefinedName_OriginalName_RefinedName(String originalName) {
        Player player = Player.create(originalName);
        assertThat(player.getRefinedName()).hasSize(MAX_NAME_LENGTH);
    }
}