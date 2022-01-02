package Domain;

import View.Input;

import java.util.ArrayList;
import java.util.List;

public class PlayerService {

    private PlayerList playerList;

    public void makePlayerList(List<String> playerInput) {
        playerList = new PlayerList(playerInput);
    }

    public PlayerList getPlayerList() {
        return playerList;
    }

    public List<Integer> getPlayerIdxLst(List<String> playerInput) {
        return playerList.getPlayerIdxLst(playerInput);
    }

    public List<Integer> getAllPlayerIdxLst() {
        return playerList.getAllPlayerIdxLst();
    }

}
