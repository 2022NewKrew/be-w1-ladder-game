package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class LineTest {
    @Test
    @DisplayName("이전 사다리가 생성되어 있으면 무조건 생성하지 않는다.")
    void lineCheck(){
        int numOfPerson = 5;
        Line line = new Line(numOfPerson);

        for(int i=0; i<numOfPerson-1; i++){
            if(line.getLine().get(i)){
                assertFalse(line.randomValue(i + 1));
            }
        }
    }
}