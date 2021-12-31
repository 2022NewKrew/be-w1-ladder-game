package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {
    @Test
    public void testSuccessNextPosition(){
        //given
        Line line = new Line(5);
        int before1 = 0;
        int before2 = 2;
        int before3 = 4;

        //when
        int after1 = line.nextPosition(before1);
        int after2 = line.nextPosition(before2);
        int after3 = line.nextPosition(before3);

        //then
        assertEquals(hasLadderBeside(line, after1), after1 != before1);
        assertEquals(hasLadderBeside(line, after2), after2 != before2);
        assertEquals(hasLadderBeside(line, after3), after3 != before3);
    }

    private static boolean hasLadderBeside(Line line, int index){
        if(index == 0){
            return line.getComponent(index+1) == ComponentType.LADDER;
        }

        if(index == line.getSize()-1){
            return line.getComponent(index-1) == ComponentType.LADDER;
        }

        return line.getComponent(index+1) == ComponentType.LADDER
                || line.getComponent(index-1) == ComponentType.LADDER;
    }
}