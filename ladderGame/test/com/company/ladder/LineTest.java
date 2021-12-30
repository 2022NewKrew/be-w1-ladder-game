package com.company.ladder;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LineTest {
    Line line;
    @Before
    public void setUp() throws Exception {
        line = new Line();
    }

    @Test
    public void setLine() {
        line.setLine(10);
        for(int i = 0; i < 9; i++){
            assertTrue(!(line.getStep(i)&&line.getStep(i+1)));
        }
    }

}