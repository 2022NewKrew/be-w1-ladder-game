package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private final int numParticipant;
    private final int height;
    private List<Line> connections;
    private List<Player> players;

    public static class Line {
        private List<Boolean> line;
        private int numberOfColumn;
        private Random random = new Random();

        public Line(int numberOfColumn){
            this.numberOfColumn = numberOfColumn;
            line = new ArrayList<>();
            for(int j = 0; j < numberOfColumn; j++){
                line.add(createCell(j));
            }
        }

        public List<Boolean> getLine() {
            return line;
        }

        private Boolean createCell(int colIndex){
            if(canConnect(colIndex)){
                return random.nextBoolean();
            }
            return Boolean.FALSE;
        }

        private boolean canConnect(int colIndex) {
            return colIndex == 0 || Boolean.FALSE.equals(line.get(colIndex - 1));
        }
    }

    public Ladder(int numParticipant, int height, List<Player> players) {
        this.numParticipant = numParticipant;
        this.height = height;
        this.players = players;
        createLadder();
    }

    public List<Line> getConnections() {
        return connections;
    }

    public List<Player> getPlayers() {
        return players;
    }

    private void createLadder(){
        connections = new ArrayList<>();
        for(int i = 0; i < height; i++){
            connections.add(createLine(numParticipant - 1));
        }
    }

    private Line createLine(int numberOfColumn){
        return new Line(numberOfColumn);
    }
}
