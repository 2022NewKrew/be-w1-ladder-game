package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {
    static Ladder ladder;

    @BeforeEach
    public void setUp(){
        this.ladder = new Ladder(5, 20);
    }

    @Test
    void testToString() {
        Stream<String> lines = ladder.toString().lines();
        assertEquals(
                lines.findFirst(),
                Optional.of("prod  honux longn  sam    k    jk   ")
        );
    }
}