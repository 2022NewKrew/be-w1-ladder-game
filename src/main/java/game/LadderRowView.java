package game;

import java.util.ArrayList;

import static game.LadderType.BAR;
import static game.LadderType.BLANK;

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
