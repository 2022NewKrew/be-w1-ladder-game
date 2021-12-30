package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinesTest {

    @Test
    public void testFailedWhenWidthShorter(){
        //given
        int width1 = -1;
        int width2 = 0;
        int height = 5;

        IllegalArgumentException illegalArgumentException1
                = assertThrows(IllegalArgumentException.class, ()->new Lines(width1, height));
        IllegalArgumentException illegalArgumentException2
                = assertThrows(IllegalArgumentException.class, ()->new Lines(width2, height));

        assertEquals(Lines.WIDTH_LENGTH_EXCEPTION_MESSAGE, illegalArgumentException1.getMessage());
        assertEquals(Lines.WIDTH_LENGTH_EXCEPTION_MESSAGE, illegalArgumentException2.getMessage());
    }
    @Test
    public void testFailedWhenHeightShorter(){
        //given
        int width = 5;
        int height1 = -1;
        int height2 = 0;

        IllegalArgumentException illegalArgumentException1
                = assertThrows(IllegalArgumentException.class, ()->new Lines(width, height1));
        IllegalArgumentException illegalArgumentException2
                = assertThrows(IllegalArgumentException.class, ()->new Lines(width, height2));

        assertEquals(Lines.HEIGHT_LENGTH_EXCEPTION_MESSAGE, illegalArgumentException1.getMessage());
        assertEquals(Lines.HEIGHT_LENGTH_EXCEPTION_MESSAGE, illegalArgumentException2.getMessage());
    }
}