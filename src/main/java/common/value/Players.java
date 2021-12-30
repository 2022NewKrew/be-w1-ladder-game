package common.value;

import java.util.List;

public class Players {

    private List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public int toIndexValue(String name) {
        for(int index = 0; index < players.size(); index++) {
            if(name.equals(players.get(index))) {
                return index;
            }
        }
        return -1;
    }

    public int getCount() {
        return players.size();
    }

    public String getPlayerName(int index) {
        return players.get(index).getName();
    }
}
