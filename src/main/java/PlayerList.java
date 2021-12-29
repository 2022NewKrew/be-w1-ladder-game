import java.util.ArrayList;

public class PlayerList {
    ArrayList<Player> players;

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
