package laddergame.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class LineFactoryTest {

    private static int count;
    private static Line line;

    @BeforeAll
    static void setParameter() {
        count = 7;
        line = LineFactory.create(count);
    }

    @Test
    @DisplayName("Line 객체 생성 확인")
    void create() {
        Line newLine = new Line(new Flags(new ArrayList<Flag>()));
        assertThat(line).hasSameClassAs(newLine);
    }

    @Test
    @DisplayName("Flags 객체 생성 확인")
    void createFlags() {
        final int MIN_INDEX = 0;
        final int MAX_INDEX = count - 1;
        Flag flag = new Flag(false);
        for (int i = MIN_INDEX; i <= MAX_INDEX; i++)
            assertThat(line.getFlagByIndex(i)).hasSameClassAs(flag);
    }
}