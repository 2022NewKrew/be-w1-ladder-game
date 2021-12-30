package Domain;

import View.Input;

import java.util.ArrayList;
import java.util.List;

public class PlayerList {
    private ArrayList<Player> players;

    public PlayerList() {
        players = new ArrayList<>();
    }

    public PlayerList(Input<ArrayList<String>> playerInput) {
        this();
        makePlayers(playerInput);
    }

    private void makePlayers(Input<ArrayList<String>> playerInput) {
        ArrayList<String> playerStrs = playerInput.getValue();
        for (String player : playerStrs)
            players.add(new Player(player));
    }

    public List<Integer> getPlayerIdxLst(Input<ArrayList<String>> playerInput) {
        ArrayList<String> playerStrs = playerInput.getValue();
        List<Integer> idxList = new ArrayList<>();
        for (int i = 0; i < playerStrs.size(); i++)
            idxList.add(getPlayerIdx(playerStrs.get(i)));
        return idxList;
    }

    public List<Integer> getAllPlayerIdxLst() {
        List<Integer> idxList = new ArrayList<>();
        for (int i = 0; i < players.size(); i++)
            idxList.add(i);
        return idxList;
    }

    int getPlayerIdx(String playerStr) {
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            if (player.getName().equals(playerStr)) return i;
        }
        return -1;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int len = (players.size() + 1) * 5 + players.size();

        for (int i = 0; i < len; i++)
            sb.append(" ");

        for (int i = 0; i < players.size(); i++) {
            int cursor = 5 + 6 * i;
            String player = players.get(i).toString();
            int mid = player.length() / 2;
            sb.replace(cursor - mid, cursor - mid + player.length(), player);
        }
        return sb.toString();
    }

}
