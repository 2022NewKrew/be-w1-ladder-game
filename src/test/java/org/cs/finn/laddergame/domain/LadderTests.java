package org.cs.finn.laddergame.domain;

import org.assertj.core.api.Assertions;
import org.cs.finn.laddergame.domain.ladder.LadderHeight;
import org.cs.finn.laddergame.domain.stringvalues.Members;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.security.SecureRandom;
import java.util.stream.Stream;

public class LadderTests {
    private static final SecureRandom secureRandom = new SecureRandom();

    @ParameterizedTest
    @MethodSource("generateNullParamater")
    @DisplayName("null이 전달되면 예외를 발생시킨다")
    @SuppressWarnings("all")
    public void testNullParamater(SecureRandom sRand, LadderHeight ladderHeight, Members members) {
        // then
        Assertions.assertThatThrownBy(() -> new Ladder(sRand, ladderHeight, members))
                .isInstanceOf(RuntimeException.class);
    }

    static Stream<Arguments> generateNullParamater() {
        return Stream.of(
                Arguments.of(null, LadderHeight.getDefault(), Members.getDefault()),
                Arguments.of(secureRandom, null, Members.getDefault()),
                Arguments.of(secureRandom, LadderHeight.getDefault(), null)
        );
    }
}
