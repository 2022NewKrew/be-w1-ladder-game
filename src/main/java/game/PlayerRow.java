package game;

import java.util.ArrayList;

import static game.Ladder.typeSize;

// Player 의 네임을 저장하는 row class
public class PlayerRow extends Row{
    public PlayerRow(ArrayList<String> playerList) {
        elementList = new ArrayList<String>();
        for(String player : playerList)
        {
            elementList.add(player);
        }
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i<elementList.size();i++)
        {
            int blankLength = getBlankLength(i);
            stringBuilder.append(" ".repeat(blankLength));
            stringBuilder.append(elementList.get(i));
        }
        return stringBuilder.toString();
    }

    private int getBlankLength(int i) {
        String element = (String) elementList.get(i);
        int blankLength = typeSize - element.length()/2;
        if(i> 0)
            blankLength -= (((String) elementList.get(i-1)).length()-1)/2;
        return blankLength;
    }
}
