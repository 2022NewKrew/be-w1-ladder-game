package ladder.domain;

import java.util.ArrayList;
import java.util.Random;

import static ladder.domain.LadderType.*;


public class LadderRow{

    private final Random random = new Random();
    private final ArrayList<LadderType> elementList = new ArrayList<>();
    public LadderRow(int numOfPerson) {
        //사람 수 - 1 만큼 element가 있어야 함.
        for(int i = 0; i<numOfPerson-1; i++)
        {
            elementList.add(decideElement());
        }
    }
    public ArrayList<LadderType> getElementList() {
        return elementList;
    }
    LadderType decideElement() {
        //|-----|-----|     방지
        if ((elementList.isEmpty() || elementList.get(elementList.size() - 1) != BRIDGE)
                && random.nextBoolean()) {
            return BRIDGE;
        }
        return BLANK;
    }

}
