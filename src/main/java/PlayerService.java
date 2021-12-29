import java.util.ArrayList;

public class PlayerService {

    PlayerList playerList;

    public void makePlayerList(Input<ArrayList<String>> playerInput) {
        playerList = new PlayerList(playerInput);
    }

    public PlayerList getPlayerList() {
        return playerList;
    }

}
