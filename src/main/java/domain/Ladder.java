package main.java.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Ladder {
    private final List<Line> lines;
    protected Ladder(List<Line> lines) {
        this.lines = lines;
    }

    private void initPlayersPosition(Players players, HashMap<Player, Integer> playersPosition){
        List<Player> playersList = players.players();
        for(int i = 0; i < playersList.size(); i++){
            playersPosition.put(playersList.get(i), i);
        }
    }

    private void movePlayersPosition(HashMap<Player, Integer> playersPosition){
        List<Line> lines = this.lines;
        for(int i = 0; i < lines.size(); i++){
            move(lines.get(i), playersPosition);
        }
    }

    private void move(Line line, HashMap<Player, Integer> playersPosition){
        for(Player player : playersPosition.keySet()){
            int position = playersPosition.get(player);
            playersPosition.put(player,line.move(position));
        }
    }

    public List<Line> lines(){
        return Collections.unmodifiableList(lines);
    }
}
