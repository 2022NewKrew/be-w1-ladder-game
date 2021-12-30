package repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class PlayerList {
    private final List<Player> players;
    private final HashMap<Integer, String> resultMapping;

    public PlayerList(){
        players = new ArrayList<>();
        resultMapping = new HashMap<>();
    }

    public void initiatePlayers(List<String> names, List<String> results){
        for(int i = 0; i < names.size(); i++){
            Player player = new Player(names.get(i));
            resultMapping.put(i, names.get(i));
            players.add(player);
        }
    }

    public void swapPlayersResult(int i){
        String tempResult = resultMapping.get(i);
        resultMapping.put(i, resultMapping.get(i+1));
        resultMapping.put(i+1, tempResult);
    }

    public int getNumOfPeople() { return players.size(); }
    public Stream<Player> getPlayersStream() { return players.stream(); }
    public HashMap<Integer, String> getResultMapping() { return resultMapping; }
}
