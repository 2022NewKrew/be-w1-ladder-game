package view;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LadderShapeTest {

    @Test
    void createTest() {
        //given
        int[][] ladder = new int[2][2];
        ladder[0][1] = 1;
        ladder[1][0] = 1;
        String expected = ("|     |-----|\n|-----|     |\n");

        //when
        LadderShape result = LadderShape.create(ladder);

        //then
        assertEquals(expected, result.getShape());
    }
}