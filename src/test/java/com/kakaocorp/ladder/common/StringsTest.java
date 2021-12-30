package com.kakaocorp.ladder.common;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringsTest {

    @ParameterizedTest
    @MethodSource("providePadParameters")
    void pad(String input, int length, String expected) {
        String actual = Strings.pad(input, length);

        assertEquals(expected, actual);
    }

    private static Stream<Arguments> providePadParameters() {
        return Stream.of(
                Arguments.of("abc", 3, "abc"),
                Arguments.of("abc", 4, "abc "),
                Arguments.of("abc", 5, " abc ")
        );
    }
}
