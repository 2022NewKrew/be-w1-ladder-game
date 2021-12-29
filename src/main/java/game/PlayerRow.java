package game;

import java.util.ArrayList;

import static game.Ladder.typeSize;

// Player 의 네임을 저장하는 row class
public class PlayerRow{

    private final ArrayList<String> playerList;
    public PlayerRow(ArrayList<String> playerList) {
        this.playerList = playerList;
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i<playerList.size();i++)
        {
            int blankLength = getBlankLength(i);
            stringBuilder.append(" ".repeat(blankLength));
            stringBuilder.append(playerList.get(i));
        }
        return stringBuilder.toString();
    }

    private int getBlankLength(int i) {
        String element = (String) playerList.get(i);
        int blankLength = typeSize - element.length()/2;
        if(i> 0)
            blankLength -= (((String) playerList.get(i-1)).length()-1)/2;
        return blankLength;
    }
}
