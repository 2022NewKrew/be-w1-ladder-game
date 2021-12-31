package domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    public void lineTest(){

        //given
        int personNum = 10;

        //when
        Line line = new Line(personNum);

        //then
        assertTrue(lineValid(line));

    }

    private boolean lineValid(Line line){
        List<Boolean> l = line.getLine();
        for(int i=1; i<l.size(); i++){
            if(l.get(i-1) && l.get(i)){
                return false;
            }
        }
        return true;
    }

}