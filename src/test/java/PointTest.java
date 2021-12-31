package test.java;

import main.java.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PointTest {
    @DisplayName("point_First_Test")
    @Test
    public void point_First_Test() {
        assertNotEquals(Point.randomPoint(),Point.LEFT);
    }

    @ParameterizedTest(name = "point_Next_RIGHT_Test")
    @MethodSource("point_Next_RIGHT_Provider")
    public void point_Next_RIGHT_Test(Point point, Point expected) {
        assertNotEquals(Point.next(point),expected);
    }

    static Stream<Arguments> point_Next_RIGHT_Provider() {
        return Stream.of(
                Arguments.of(Point.RIGHT, Point.DOWN),
                Arguments.of(Point.RIGHT, Point.RIGHT)
        );
    }

    @ParameterizedTest(name = "point_Next_Test")
    @MethodSource("point_Next_Provider")
    public void point_Next_Test(Point point, Point expected) {
        assertNotEquals(Point.next(point),expected);
    }

    static Stream<Arguments> point_Next_Provider() {
        return Stream.of(
                Arguments.of(Point.LEFT, Point.LEFT),
                Arguments.of(Point.DOWN, Point.LEFT)
        );
    }

    @ParameterizedTest(name = "point_Last_Test")
    @MethodSource("point_Last_Provider")
    public void point_Last_Test(Point point, Point expected) {
        assertEquals(Point.last(point),expected);
    }

    static Stream<Arguments> point_Last_Provider() {
        return Stream.of(
                Arguments.of(Point.RIGHT, Point.LEFT),
                Arguments.of(Point.DOWN, Point.DOWN),
                Arguments.of(Point.LEFT, Point.DOWN)
        );
    }
}
