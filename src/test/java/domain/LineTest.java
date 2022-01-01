package domain;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class LineTest {
    @Test
    public void 연속된_선이_있는지(){
        int NUM_PEOPLE = 5;
        Line line = new Line(NUM_PEOPLE);
        ArrayList<Boolean> connections = line.getConnections();

        boolean existSequence = false;
        for(int idx=1; idx < NUM_PEOPLE-1; idx++) {
            if (connections.get(idx) && connections.get(idx - 1)) {
                existSequence = true;
                break;
            }
        }
        assertFalse(existSequence);
    }
}
