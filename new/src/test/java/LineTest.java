import ladder.domain.Line;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

class LineTest {
    static Line line;
    static ArrayList<Boolean> cells;

    @BeforeEach
    public void setup(){
        line = new Line(10);
        cells = line.getCells();
    }

    @Test
    public void lineTest(){
        for (int i=0; i< cells.size()-1;i++){
            if( cells.get(i)){
                assertThat(cells.get(i)).isNotEqualTo( cells.get(i+1));
            }
        }

    }

}