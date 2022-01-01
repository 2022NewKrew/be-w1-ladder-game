package Domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Players implements Iterable<Player> {
    List<Player> players;

    public Players(List<String> playerInput) {
        players = new ArrayList<>();
        for (String playerStr : playerInput)
            players.add(new Player(playerStr));
    }

    @Override
    public Iterator<Player> iterator() {
        return players.iterator();
    }

    int getPlayerIdx(String playerStr) {
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            if (player.is(playerStr)) return i;
        }
        return -1;
    }

    public List<Integer> getAllPlayerIdxLst() {
        List<Integer> idxList = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            idxList.add(i);
        }
        return idxList;
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public int size() {
        return players.size();
    }

    public Player get(int idx) {
        return players.get(idx);
    }

    public String toString() {
        return players.toString();
    }
}
