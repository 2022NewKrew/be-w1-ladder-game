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
        this.ladder = new Ladder(
                new ArrayList<String>(Arrays.asList("prod", "honux", "longname", "sam", "k", "jk")),
                20
        );
    }

    @Test
    public void testConstructor(){
        //personNames가 null일 때
        assertThrows(IllegalArgumentException.class, ()->new Ladder(null, 20));

        //빈 personNames일 때
        assertThrows(IllegalArgumentException.class, ()->new Ladder(new ArrayList<>(), 20));

        //height이 0일 때
        assertThrows(IllegalArgumentException.class, ()->new Ladder(new ArrayList<>(Arrays.asList("a", "bb", "ccc")), 0));

        //height이 음수일 때
        assertThrows(IllegalArgumentException.class, ()->new Ladder(new ArrayList<>(Arrays.asList("a", "bb", "ccc")), -5));
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