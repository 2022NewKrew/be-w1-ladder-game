package ladder.view;

import java.util.ArrayList;

import static ladder.domain.Ladder.typeSize;

// Player 의 네임을 저장하는 row class
public class PlayerRowView {

    private final ArrayList<String> playerList;
    public PlayerRowView(ArrayList<String> playerList) {
        this.playerList = playerList;
    }

    public String DrawElement() {
        StringBuilder stringBuilder = new StringBuilder();
        String stringFormat = "%" + (typeSize +1) + "s";
        for(String player : playerList)
        {
            stringBuilder.append(String.format(stringFormat,player));
        }
        return stringBuilder.toString();
    }

}
