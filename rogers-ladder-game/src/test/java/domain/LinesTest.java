package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinesTest {

    @Test
    public void testFailedWhenWidthShorter() {
        //given

        //when
        IllegalArgumentException illegalArgumentException1
                = assertThrows(IllegalArgumentException.class, () -> new Lines(-1, 5));
        IllegalArgumentException illegalArgumentException2
                = assertThrows(IllegalArgumentException.class, () -> new Lines(0, 5));
        IllegalArgumentException illegalArgumentException3
                = assertThrows(IllegalArgumentException.class, () -> new Lines(5, -1));

        //then
        assertEquals(Lines.LENGTH_EXCEPTION_MESSAGE, illegalArgumentException1.getMessage());
        assertEquals(Lines.LENGTH_EXCEPTION_MESSAGE, illegalArgumentException2.getMessage());
    }
}