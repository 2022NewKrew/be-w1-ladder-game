package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {
    @Test
    @DisplayName("이전 사다리가 생성되어 있으면 무조건 생성하지 않는다.")
    void lineCheck(){
        int numOfPerson = 5;
        Line line = new Line(numOfPerson);

        List<Boolean> lineList = line.getLine();
        for(int i=0; i<numOfPerson-1; i++){
            if(lineList.get(i)){
                assertFalse(lineList.get(i+1));
            }
        }
    }
}