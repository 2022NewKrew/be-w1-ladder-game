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
        String stringFormat = "%" + (typeSize +1) + "s";
        for(String player : playerList)
        {
            stringBuilder.append(String.format(stringFormat,player));
        }
        return stringBuilder.toString();
    }

}
