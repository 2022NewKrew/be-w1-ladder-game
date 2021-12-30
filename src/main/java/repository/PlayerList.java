package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class PlayerList {
    private final List<Player> players;

    public PlayerList(){
        players = new ArrayList<>();
    }

    public void initiatePlayers(List<String> names, List<String> results){
        for(int i = 0; i < names.size(); i++){
            Player player = new Player(names.get(i), results.get(i));
            players.add(player);
        }
    }

    public void swapPlayersResult(int i){
        String tempResult = players.get(i).getResult();
        players.get(i).setResult(players.get(i+1).getResult());
        players.get(i+1).setResult(tempResult);
    }

    public int getNumOfPeople() { return players.size(); }
    public Stream<Player> getPlayersStream() { return players.stream(); }
}
