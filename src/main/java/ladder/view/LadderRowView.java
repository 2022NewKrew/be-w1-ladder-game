package ladder.view;

import ladder.domain.LadderType;

import java.util.ArrayList;

import static ladder.domain.LadderType.BAR;
import static ladder.domain.LadderType.BLANK;

public class LadderRowView {
    public static String DrawElement(ArrayList<LadderType> elementList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(BLANK);
        stringBuilder.append(BAR);
        for(var element : elementList)
        {
            stringBuilder.append(element);
            stringBuilder.append(BAR);
        }
        return stringBuilder.toString();
    }
}
