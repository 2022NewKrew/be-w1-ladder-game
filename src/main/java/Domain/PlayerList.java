package Domain;

import java.util.ArrayList;
import java.util.List;

public class PlayerList {
    private Players players;

    public PlayerList(List<String> playerInput) {
        players = new Players(playerInput);
    }

    public List<Integer> getPlayerIdxLst(List<String> playerStrs) {
        List<Integer> idxList = new ArrayList<>();
        for (int i = 0; i < playerStrs.size(); i++)
            idxList.add(players.getPlayerIdx(playerStrs.get(i)));
        return idxList;
    }

    public List<Integer> getAllPlayerIdxLst() {
        return players.getAllPlayerIdxLst();
    }

    public Players getPlayers() {
        return players;
    }

    public String toString() {
        return players.toString();
    }

}
